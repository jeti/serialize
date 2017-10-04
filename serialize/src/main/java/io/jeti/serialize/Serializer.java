package io.jeti.serialize;

import java.io.IOException;

public interface Serializer<T> {

    /**
     * @return a String containing the serialized object which can later be
     *         deserialized using the {@link #fromString(String)} method.
     *         Specifically, given an object "o" and {@link Serializer} "s", we
     *         should find that
     * 
     *         <pre>
     * <code>o.equals(s.fromString(s.toString(o)))</code>
     *         </pre>
     */
    String toString(T object) throws IOException;

    /**
     * @return an Object deserialized from the specified String. The String
     *         should have been generated using the {@link #toString(Object)}
     *         method. Specifically, given an object "o" and {@link Serializer}
     *         "s", we should find that
     * 
     *         <pre>
     * <code>o.equals(s.fromString(s.toString(o)))</code>
     *         </pre>
     */
    Object fromString(String string) throws ClassNotFoundException, IOException;
}