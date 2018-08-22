package net.pubnative.openrtb.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {
    private static final String BASE_URL_PN = "http://dsp.pubnative.net/bid/v1/";
    private final PNRTBService mPNRTBService;

    private static ServiceProvider sInstance;

    private ServiceProvider() {
        this.mPNRTBService = createPNService();
    }

    public static ServiceProvider getInstance() {
        if (sInstance == null) {
            synchronized (ServiceProvider.class) {
                if (sInstance == null) {
                    sInstance = new ServiceProvider();
                }
            }
        }
        return sInstance;
    }

    private PNRTBService createPNService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_PN)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getHttpClient())
                .build();

        return retrofit.create(PNRTBService.class);
    }

    private Gson getGson() {
        return new GsonBuilder().create();
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder()
                        .header("x-openrtb-version", "2.3")
                        .header("Content-Type", "application/json")
                        .header("Accept-Charset", "utf-8");

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
    }

    public PNRTBService getPNRTBService() {
        return mPNRTBService;
    }
}
