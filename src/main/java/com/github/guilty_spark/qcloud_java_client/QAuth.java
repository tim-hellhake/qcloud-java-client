package com.github.guilty_spark.qcloud_java_client;

import com.github.guilty_spark.qcloud_java_client.model.Token;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * QApi authentication rest interface
 *
 * @author guilty-spark
 */
public interface QAuth {
    /**
     * Create  new instance of the QAuth service.
     * Defaults to the cloud api endpoint (http://q.daskeyboard.com/oauth/1.4/)
     *
     * @return an instance of the qApi with the specified access key
     */
    static QAuth create() {
        return create("http://q.daskeyboard.com/oauth/1.4/");
    }

    /**
     * Create new instance of the QAuth service.
     *
     * @param endpoint the api endpoint
     * @return an instance of the qApi with the specified access key
     */
    static QAuth create(String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(QAuth.class);
    }

    default Observable<Token> createTokenByPassword(String email, String password) {
        return createTokenByPassword(email, password, "password");
    }

    @POST("token")
    @FormUrlEncoded
    Observable<Token> createTokenByPassword(@Field("email") String email,
                                            @Field("password") String password,
                                            @Field("grant_type") String grantType);

    default Observable<Token> createTokenByClientSecret(String client_id, String client_secret) {
        return createTokenByClientSecret(client_id, client_secret, "client_credentials");
    }

    @POST("token")
    @FormUrlEncoded
    Observable<Token> createTokenByClientSecret(@Field("client_id") String clientId,
                                                @Field("client_secret") String clientSecret,
                                                @Field("grant_type") String grantType);

    default Observable<Token> refreshToken(String clientId, String refreshToken) {
        return refreshToken(clientId, refreshToken, "refresh_token");
    }

    @POST("refresh_token")
    @FormUrlEncoded
    Observable<Token> refreshToken(@Field("client_id") String clientId,
                                   @Field("refresh_token") String refreshToken,
                                   @Field("grant_type") String grantType);
}
