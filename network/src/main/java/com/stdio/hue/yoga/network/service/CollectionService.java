package com.stdio.hue.yoga.network.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.rx2.Rx2Apollo;
import com.stdio.hue.yoga.network.GetCollectionDetailQuery;
import com.stdio.hue.yoga.network.GetCollectionsOfACategoryQuery;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class CollectionService {
    private ApolloClient apolloClient;

    public CollectionService(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public Observable<Response<GetCollectionDetailQuery.Data>> getCollectionDetail(int id, String language) {
        GetCollectionDetailQuery getCollectionDetailQuery = GetCollectionDetailQuery.builder().id(id).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetCollectionDetailQuery.Data> apolloCall = apolloClient.query(getCollectionDetailQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetCollectionsOfACategoryQuery.Data>> getCollectionsOfACategory(int limit, int page, int categoryId, String where, String language) {
        GetCollectionsOfACategoryQuery getCollectionsOfACategoryQuery = GetCollectionsOfACategoryQuery.builder().limit(limit).page(page).category_id(categoryId).where(where).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        return Rx2Apollo.from(apolloClient.query(getCollectionsOfACategoryQuery));
    }
}
