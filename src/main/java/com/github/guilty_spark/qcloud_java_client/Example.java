package com.github.guilty_spark.qcloud_java_client;

import com.github.guilty_spark.qcloud_java_client.model.Client;
import com.github.guilty_spark.qcloud_java_client.model.Error;
import com.github.guilty_spark.qcloud_java_client.model.Signal;
import com.github.guilty_spark.qcloud_java_client.model.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;

import java.io.IOException;
import java.util.function.Function;

/**
 * QApi example class
 *
 * @author guilty-spark
 */
public class Example {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        final String pid = "DK5QPID";
        final String clientId = "...";
        final String clientSecret = "...";

        printTokenByClientSecret(clientId, clientSecret);
        //printTokenByPassword("[EMAIL]", "[PASSWORD]");
        //deleteAllSignals(clientId, clientSecret);
        execute(clientId, clientSecret, QApi::getClients);
        execute(clientId, clientSecret, qApi -> qApi.revokeClient(new Client("[CLIENT_NAME]")));
        execute(clientId, clientSecret, QApi::getDeviceDefinitions);
        execute(clientId, clientSecret, QApi::getDevices);
        execute(clientId, clientSecret, QApi::getColors);
        execute(clientId, clientSecret, qApi -> qApi.getZones(pid));
        execute(clientId, clientSecret, qApi -> qApi.getEffects(pid));
        execute(clientId, clientSecret, qApi -> qApi.createSignal(new Signal("Test", pid, "#FF0000", "KEY_A")));
        execute(clientId, clientSecret, QApi::getSignals);
        execute(clientId, clientSecret, qApi ->
                qApi.createSignal(new Signal("Test a", pid, "#FF0000", "KEY_A"))
                        .flatMap(signal -> qApi.updateSignal(signal.getId(), new Status(false, false)))
                        .flatMap(signal -> qApi.deleteSignal(signal.getId()))
        );
    }

    private static void printTokenByPassword(String email, String password) {
        QAuth qAuth = QAuth.create();

        qAuth.createTokenByPassword(email, password)
                .subscribe(Example::printValue, Example::printError);
    }

    private static void printTokenByClientSecret(String clientId, String clientSecret) {
        QAuth qAuth = QAuth.create();

        qAuth.createTokenByClientSecret(clientId, clientSecret)
                .subscribe(Example::printValue, Example::printError);
    }

    private static void deleteAllSignals(String clientId, String clientSecret) {
        execute(clientId, clientSecret, qApi ->
                qApi.getSignals()
                        .flatMap(x -> Observable.from(x.getContent()))
                        .flatMap(signal -> qApi.deleteSignal(signal.getId()))
        );
    }

    private static <R> void execute(String clientId, String clientSecret, Function<QApi, Observable<R>> function) {
        QAuth qAuth = QAuth.create();

        qAuth.createTokenByClientSecret(clientId, clientSecret)
                .map(token -> QApi.create(token.getAccessToken()))
                .flatMap(function::apply)
                .subscribe(Example::printValue, Example::printError);
    }

    private static void printValue(Object o) {
        System.out.println(gson.toJson(o));
    }

    private static void printError(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            try {
                String body = httpException.response().errorBody().string();
                System.err.println(gson.toJson(gson.fromJson(body, Error.class)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throwable.printStackTrace();
        }
    }
}
