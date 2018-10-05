package com.stdio.hue.yoga.network.di;

import com.apollographql.apollo.ApolloClient;
import com.stdio.hue.yoga.network.BuildConfig;
import com.stdio.hue.yoga.network.service.BannerService;
import com.stdio.hue.yoga.network.service.CategoryService;
import com.stdio.hue.yoga.network.service.ClassService;
import com.stdio.hue.yoga.network.service.CollectionService;

import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NetworkModule {
    @Provides
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        httpClient.addInterceptor(chain -> {
            Request request = chain.request();
            Response response = chain.proceed(request);
            try {
                int code = response.code();
                if (code < 200 || code > 299) {
                    if (response.body() != null) {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        String messageError = null;
                        if (jsonObject.has("message")) {
                            messageError = jsonObject.getString("message");
                        }
                        throw new IOException(messageError);
                    }
                }
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
            return response;
        });
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    @Provides
    @Named("Base")
    public ApolloClient provideApolloClient(OkHttpClient.Builder httpClient) {
        return ApolloClient.builder()
                .serverUrl(BuildConfig.SERVER_URL)
                .okHttpClient(httpClient.build())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()
                .build();
    }

    @Provides
    public BannerService provideBannerService(@Named("Base") ApolloClient apolloClient) {
        return new BannerService(apolloClient);
    }

    @Provides
    public CategoryService provideCategoryService(@Named("Base") ApolloClient apolloClient) {
        return new CategoryService(apolloClient);
    }

    @Provides
    public ClassService provideClassService(@Named("Base") ApolloClient apolloClient) {
        return new ClassService(apolloClient);
    }

    @Provides
    public CollectionService provideCollectionService(@Named("Base") ApolloClient apolloClient) {
        return new CollectionService(apolloClient);
    }
}
