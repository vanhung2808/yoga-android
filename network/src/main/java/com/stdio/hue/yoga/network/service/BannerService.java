package com.stdio.hue.yoga.network.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.rx2.Rx2Apollo;
import com.stdio.hue.yoga.network.BannerQuery;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class BannerService {
    private ApolloClient apolloClient;

    public BannerService(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public Observable<Response<BannerQuery.Data>> getBanners(String language) {
        BannerQuery bannerQuery = BannerQuery.builder().build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<BannerQuery.Data> apolloCall = apolloClient.query(bannerQuery);
        return Rx2Apollo.from(apolloCall);
    }
}