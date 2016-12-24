package com.github.guilty_spark.qcloud_java_client.model;

/**
 * A possible color
 *
 * @author guilty-spark
 */
public class Color {
    private final String code = null;
    private final String name = null;

    /**
     * @return the hexadecimal code of the color (string beginning by the character '#' and followed by 3 hexadecimal digits)
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the name of the color
     */
    public String getName() {
        return name;
    }
}
