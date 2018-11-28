package com.stdio.hue.yoga.network.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.rx2.Rx2Apollo;
import com.stdio.hue.yoga.network.GetAbilityQuery;
import com.stdio.hue.yoga.network.GetBannerQuery;
import com.stdio.hue.yoga.network.GetCategoryQuery;
import com.stdio.hue.yoga.network.GetClassesQuery;
import com.stdio.hue.yoga.network.GetCollectionQuery;
import com.stdio.hue.yoga.network.GetDurationQuery;
import com.stdio.hue.yoga.network.GetFocusQuery;
import com.stdio.hue.yoga.network.GetIntensityQuery;
import com.stdio.hue.yoga.network.GetPoseQuery;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class DataService {
    private ApolloClient apolloClient;

    public DataService(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public Observable<Response<GetAbilityQuery.Data>> getAbilities(String timeUpdate, String language) {
        GetAbilityQuery getAbilityQuery = GetAbilityQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetAbilityQuery.Data> apolloCall = apolloClient.query(getAbilityQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetBannerQuery.Data>> getBanners(String timeUpdate, String language) {
        GetBannerQuery getBannerQuery = GetBannerQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetBannerQuery.Data> apolloCall = apolloClient.query(getBannerQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetCategoryQuery.Data>> getCategories(String timeUpdate, String language) {
        GetCategoryQuery getCategoryQuery = GetCategoryQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetCategoryQuery.Data> apolloCall = apolloClient.query(getCategoryQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetClassesQuery.Data>> getClasses(String timeUpdate, String language) {
        GetClassesQuery getClassesQuery = GetClassesQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetClassesQuery.Data> apolloCall = apolloClient.query(getClassesQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetCollectionQuery.Data>> getCollections(String timeUpdate, String language) {
        GetCollectionQuery getCollectionQuery = GetCollectionQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetCollectionQuery.Data> apolloCall = apolloClient.query(getCollectionQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetDurationQuery.Data>> getDurations(String timeUpdate, String language) {
        GetDurationQuery getDurationQuery = GetDurationQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetDurationQuery.Data> apolloCall = apolloClient.query(getDurationQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetFocusQuery.Data>> getFocus(String timeUpdate, String language) {
        GetFocusQuery getFocusQuery = GetFocusQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetFocusQuery.Data> apolloCall = apolloClient.query(getFocusQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetIntensityQuery.Data>> getIntensities(String timeUpdate, String language) {
        GetIntensityQuery getIntensityQuery = GetIntensityQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetIntensityQuery.Data> apolloCall = apolloClient.query(getIntensityQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetPoseQuery.Data>> getPoses(String timeUpdate, String language) {
        GetPoseQuery getPoseQuery = GetPoseQuery.builder().update(timeUpdate).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetPoseQuery.Data> apolloCall = apolloClient.query(getPoseQuery);
        return Rx2Apollo.from(apolloCall);
    }
}
