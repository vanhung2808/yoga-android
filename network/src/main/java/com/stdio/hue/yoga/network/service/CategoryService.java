package com.stdio.hue.yoga.network.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.rx2.Rx2Apollo;
import com.stdio.hue.yoga.network.GetAllCategoryQuery;
import com.stdio.hue.yoga.network.GetCategoryDetailQuery;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class CategoryService {
    private ApolloClient apolloClient;

    public CategoryService(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public Observable<Response<GetAllCategoryQuery.Data>> getAllCategory(String language) {
        GetAllCategoryQuery getAllCategoryQuery = GetAllCategoryQuery.builder().build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetAllCategoryQuery.Data> apolloCall = apolloClient.query(getAllCategoryQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetCategoryDetailQuery.Data>> getCategoryDetail(int id, boolean includeCollection, String language) {
        GetCategoryDetailQuery getCategoryDetailQuery = GetCategoryDetailQuery.builder().id(id).includeCollection(includeCollection).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetCategoryDetailQuery.Data> apolloCall = apolloClient.query(getCategoryDetailQuery);
        return Rx2Apollo.from(apolloCall);
    }
}
