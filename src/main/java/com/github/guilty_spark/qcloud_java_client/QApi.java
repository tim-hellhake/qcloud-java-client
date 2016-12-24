package com.github.guilty_spark.qcloud_java_client;

import com.github.guilty_spark.qcloud_java_client.model.*;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;
import rx.Observable;

/**
 * QApi rest interface
 *
 * @author guilty-spark
 */
public interface QApi {
    /**
     * Create a new instance of the QApi service.
     * Defaults to the cloud api endpoint (http://q.daskeyboard.com/api/1.0/).
     *
     * @param accessKey the access key
     * @return an instance of the qApi with the specified access key
     */
    static QApi create(String accessKey) {
        return create(accessKey, "http://q.daskeyboard.com/api/1.0/");
    }

    /**
     * Create a new instance of the QApi service.
     *
     * @param accessKey the access key
     * @param endpoint  the api endpoint
     * @return an instance of the qApi with the specified access key
     */
    static QApi create(String accessKey, String endpoint) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                        .header("Authorization", "Bearer " + accessKey)
                        .build()
                )).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(QApi.class);
    }

    @GET("users/authorized_clients")
    Observable<Client[]> getClients();

    @POST("users/revoke_client")
    Observable<Void> revokeClient(@Body Client client);

    @GET("device_definitions")
    Observable<DeviceDefinition[]> getDeviceDefinitions();

    @GET("devices")
    Observable<Device[]> getDevices();

    @GET("colors")
    Observable<Color[]> getColors();

    @GET("{pid}/zones")
    Observable<Zone[]> getZones(@Path("pid") String pid);

    @GET("{pid}/effects")
    Observable<Effect[]> getEffects(@Path("pid") String pid);

    @POST("signals")
    Observable<Signal> createSignal(@Body Signal signal);

    @GET("signals")
    Observable<Signals> getSignals();

    @PATCH("signals/{id}/status")
    Observable<Signal> updateSignal(@Path("id") Long id, @Body Status status);

    @DELETE("signals/{id}")
    Observable<Void> deleteSignal(@Path("id") Long id);
}
