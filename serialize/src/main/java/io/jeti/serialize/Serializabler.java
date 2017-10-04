package io.jeti.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A {@link Serializer} using Java's built-in {@link Serializable} capabilities.
 */
public class Serializabler implements Serializer<Serializable> {

    @Override
    public String toString(Serializable object) throws IOException {
        ObjectOutputStream oos = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return new String(Base64.getUrlEncoder().encode(baos.toByteArray()), "UTF-8");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object fromString(String string) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = null;
        try {
            byte[] data = Base64.getUrlDecoder().decode(string);
            ois = new ObjectInputStream(new ByteArrayInputStream(data));
            return ois.readObject();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
