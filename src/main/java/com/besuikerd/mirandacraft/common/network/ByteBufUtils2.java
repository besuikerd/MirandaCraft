package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.besuikerd.mirandacraft.common.utils.tuple.Tuple2;

import cpw.mods.fml.common.network.ByteBufUtils;


public class ByteBufUtils2 {
	public enum Type{
		INTEGER,
		STRING,
		BOOLEAN,
		CHAR,
		SERIALIZABLE
		;
	}
	
	public static void writeSerializable(ByteBuf buf, Serializable o) {
		if(Integer.class.isInstance(o)){
			System.out.println("writing int...");
			buf.writeByte(Type.INTEGER.ordinal());
			buf.writeInt((Integer) o);
		} else if(o instanceof String){
			buf.writeByte(Type.STRING.ordinal());
			ByteBufUtils.writeUTF8String(buf, (String) o);
		}else if(Boolean.class.isInstance(o)){
			buf.writeByte(Type.BOOLEAN.ordinal());
			buf.writeBoolean((Boolean) o);
		} else if(Character.class.isInstance(o)){
			buf.writeByte(Type.CHAR.ordinal());
			buf.writeChar((Character) o);
		}else{
			buf.writeByte(Type.SERIALIZABLE.ordinal());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try{
				new ObjectOutputStream(bos).writeObject(o);
			} catch(IOException e){
				throw new IllegalArgumentException("Unable to write serializable, cause: " + e.getMessage());
			}
			byte[] bytes = bos.toByteArray();
			buf.writeInt(bytes.length);
			buf.writeBytes(bytes);
		}
	}
	
	public static Tuple2<Type, Serializable> readSerializableWithType(ByteBuf buf){
		byte t = buf.readByte();
		if(t >= 0 && t < Type.values().length){
			Type type = Type.values()[t];
			switch(type){
			case INTEGER:
				return new Tuple2<Type, Serializable>(type, buf.readInt());
			case STRING:
				return new Tuple2<Type, Serializable>(type, ByteBufUtils.readUTF8String(buf));
			case BOOLEAN:
				return new Tuple2<Type, Serializable>(type, buf.readBoolean());
			case CHAR:
				return new Tuple2<Type, Serializable>(type, buf.readChar());
			case SERIALIZABLE:
				int length = buf.readInt();
				byte[] bytes = new byte[length];
				buf.readBytes(bytes);
				ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
				try {
					return new Tuple2<Type, Serializable>(type, (Serializable) new ObjectInputStream(bis).readObject());
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			default:
				//should not be possible
				throw new UnsupportedOperationException("Type not implemented: " + type);
			}
		} else{
			throw new RuntimeException("Read serializable of unknown type: " + t);
		}
	}
	
	public static Serializable readSerializable(ByteBuf buf){
		return readSerializableWithType(buf)._2;
	}
}
