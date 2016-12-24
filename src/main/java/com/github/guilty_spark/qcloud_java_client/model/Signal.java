package com.github.guilty_spark.qcloud_java_client.model;

/**
 * A signal
 *
 * @author guilty-spark
 */
public class Signal {
    private final Long id = null;
    private final Integer userId = null;
    private final String clientName = null;
    private final Long readAt = null;
    private final Long createdAt = null;
    private final Long updatedAt = null;
    private final String pid;
    private final String zoneId;
    private final String name;
    private final String color;
    private String effect;
    private Boolean isRead;
    private Boolean isMuted;
    private Boolean isArchived;
    private Boolean shouldNotify;
    private String message;

    /**
     * Creates a new signal with all mandatory fields
     *
     * @param name   the name of the signal
     * @param pid    the pid of the device
     * @param color  the color of the Signal (string beginning by the character '#' and followed by 3 hexadecimal digits)
     * @param zoneId the id of the zone
     */
    public Signal(String name, String pid, String color, String zoneId) {
        this.name = name;
        this.pid = pid;
        this.color = color;
        this.zoneId = zoneId;
    }

    /**
     * @return the id of the Signal
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the id of the user
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @return the pid of the device
     */
    public String getPid() {
        return pid;
    }

    /**
     * @return the id of the zone
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * @return the name of the Signal
     */
    public String getName() {
        return name;
    }

    /**
     * @return the color of the Signal (string beginning by the character '#' and followed by 3 hexadecimal digits)
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the effect of the Signal
     */
    public String getEffect() {
        return effect;
    }

    /**
     * @param effect the effect of the Signal
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * @return true if the Signal has been read
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     * @param isRead if the Signal has been read
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * @return true if the Signal has been muted
     */
    public Boolean getIsMuted() {
        return isMuted;
    }

    /**
     * @param isMuted if the Signal has been muted
     */
    public void setIsMuted(Boolean isMuted) {
        this.isMuted = isMuted;
    }

    /**
     * @return true if the Signal has been archived
     */
    public Boolean getIsArchived() {
        return isArchived;
    }

    /**
     * @param isArchived if the Signal has been archived
     */
    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    /**
     * @return true if the Signal should notify the user when received
     */
    public Boolean getShouldNotify() {
        return shouldNotify;
    }

    /**
     * @param shouldNotify if the Signal should notify the user when received
     */
    public void setShouldNotify(Boolean shouldNotify) {
        this.shouldNotify = shouldNotify;
    }

    /**
     * @return the name of the Client who created the Signal
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @return the message of the Signal
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message message of the Signal
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the time at which the Signal has been read
     */
    public Long getReadAt() {
        return readAt;
    }

    /**
     * @return the time at which the Signal has been created
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the time at which the Signal has been updated
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }
}
