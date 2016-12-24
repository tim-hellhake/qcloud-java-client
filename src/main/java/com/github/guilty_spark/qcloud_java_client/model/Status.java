package com.github.guilty_spark.qcloud_java_client.model;

/**
 * The status of a signal
 *
 * @author guilty-spark
 */
public class Status {
    private final Boolean isRead;
    private final Boolean isArchived;

    /**
     * Creates a new status with all mandatory fields
     *
     * @param isRead     if the Signal has been read
     * @param isArchived if the Signal has been archived
     */
    public Status(Boolean isRead, Boolean isArchived) {
        this.isRead = isRead;
        this.isArchived = isArchived;
    }

    /**
     * @return true if the Signal has been read
     */
    public Boolean getRead() {
        return isRead;
    }

    /**
     * @return true if the Signal has been archived
     */
    public Boolean getArchived() {
        return isArchived;
    }
}
