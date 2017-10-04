package io.jeti.serialize;

import java.io.IOException;
import java.io.Serializable;

public class Serialize {

    /**
     * @return the default {@link Serializer} which uses Java's built-in
     *         serialization capabilities.
     */
    public static Serializer getDefaultSerializer() {
        return new Serializabler();
    }

    /**
     * Write a {@link Serializable} object to a url-safe {@link Base64} string.
     */
    public static String toString(Object object) throws IOException {
        return getDefaultSerializer().toString(object);
    }

    /**
     * Read a {@link Serializable} object from a serialized, url-safe
     * {@link Base64} string of that object.
     */
    public static Object fromString(String string) throws ClassNotFoundException, IOException {
        return getDefaultSerializer().fromString(string);
    }
}