package com.github.guilty_spark.qcloud_java_client.model;

import java.util.List;

/**
 * A device
 *
 * @author guilty-spark
 */
public class Device {
    private final String id = null;
    private final String userId = null;
    private final String pid = null;
    private final String firmwareVersion = null;
    private final String vid = null;
    private final String description = null;
    private final List<Zone> zones = null;

    /**
     * @return the id of the device
     */
    public String getId() {
        return id;
    }

    /**
     * @return the id of the user
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the pid of the product
     */
    public String getPid() {
        return pid;
    }

    /**
     * @return the version of the firmware
     */
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * @return the vid of the product
     */
    public String getVid() {
        return vid;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the list of zones
     */
    public List<Zone> getZones() {
        return zones;
    }
}
