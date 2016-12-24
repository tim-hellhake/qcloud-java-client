package com.github.guilty_spark.qcloud_java_client.model;

/**
 * An api client
 *
 * @author guilty-spark
 */
public class Client {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    /**
     * @return the name of the client
     */
    public String getName() {
        return name;
    }
}
