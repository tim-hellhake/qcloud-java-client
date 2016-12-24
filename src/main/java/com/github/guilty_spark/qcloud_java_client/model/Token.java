package com.github.guilty_spark.qcloud_java_client.model;

import com.google.gson.annotations.SerializedName;

/**
 * An api token
 *
 * @author guilty-spark
 */
public class Token {
    @SerializedName("access_token")
    private final String accessToken = null;
    @SerializedName("refresh_token")
    private final String refreshToken = null;
    @SerializedName("user_id")
    private final String userId = null;

    /**
     * @return the access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @return the refresh token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @return the id of the user
     */
    public String getUserId() {
        return userId;
    }
}
