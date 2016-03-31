package com.microsoft.xrm.sdk.Client;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created on 3/6/2015.
 */
public abstract class ServiceProxy {

    private String endpoint;
    private Interceptor authHeader;

    protected ServiceProxy(@NonNull String endpoint, @NonNull final String sessionToken,
                           @Nullable final ArrayMap<String, String> headers) {
        this.endpoint = endpoint;
        this.authHeader = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder builder = request.newBuilder()
                        .addHeader("Authorization", "Bearer " + sessionToken.replaceAll("(\\r|\\n)", ""));

                if (headers != null) {
                    int count = headers.size();
                    for (int i = 0; i < count; i++) {
                        builder.addHeader(headers.keyAt(i), headers.valueAt(i));
                    }
                }

                return chain.proceed(builder.build());
            }
        };
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public Interceptor getAuthHeader() {
        return this.authHeader;
    }
}
