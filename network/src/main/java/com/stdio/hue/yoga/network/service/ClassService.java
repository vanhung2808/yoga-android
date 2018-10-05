package com.stdio.hue.yoga.network.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.rx2.Rx2Apollo;
import com.stdio.hue.yoga.network.GetClassDetailQuery;
import com.stdio.hue.yoga.network.GetClassesOfCollectionQuery;

import io.reactivex.Observable;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class ClassService {
    private ApolloClient apolloClient;

    public ClassService(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public Observable<Response<GetClassDetailQuery.Data>> getClassDetail(int id, String language) {
        GetClassDetailQuery getClassDetailQuery = GetClassDetailQuery.builder().id(id).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetClassDetailQuery.Data> apolloCall = apolloClient.query(getClassDetailQuery);
        return Rx2Apollo.from(apolloCall);
    }

    public Observable<Response<GetClassesOfCollectionQuery.Data>> getClassesOfCollection(int limit, int page, int collectionId, String where, String language) {
        GetClassesOfCollectionQuery getClassesOfCollectionQuery = GetClassesOfCollectionQuery.builder().limit(limit).page(page).collection_id(collectionId).where(where).build();
        apolloClient.defaultCacheHeaders().toBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Language", language);
        ApolloCall<GetClassesOfCollectionQuery.Data> apolloCall = apolloClient.query(getClassesOfCollectionQuery);
        return Rx2Apollo.from(apolloCall);
    }
}
