package com.github.guilty_spark.qcloud_java_client.model;

import java.util.List;

/**
 * A device definition
 *
 * @author guilty-spark
 */
public class DeviceDefinition {
    private final String latestFirmwareVersion = null;
    private final String name = null;
    private final String vid = null;
    private final String pid = null;
    private final String modelNumber = null;
    private final String description = null;
    private final List<Zone> zones = null;
    private final VidPid vidPid = null;

    /**
     * @return the latest version of the firmware
     */
    public String getLatestFirmwareVersion() {
        return latestFirmwareVersion;
    }

    /**
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * @return the vid of the product
     */
    public String getVid() {
        return vid;
    }


    /**
     * @return the pid of the product
     */
    public String getPid() {
        return pid;
    }

    /**
     * @return the number of the model
     */
    public String getModelNumber() {
        return modelNumber;
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

    /**
     * @return the vid and pid of the product
     */
    public VidPid getVidPid() {
        return vidPid;
    }
}
