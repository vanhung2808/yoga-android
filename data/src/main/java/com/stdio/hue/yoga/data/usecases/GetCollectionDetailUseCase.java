package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetCollectionDetailQuery;
import com.stdio.hue.yoga.network.service.CollectionService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetCollectionDetailUseCase extends BaseUseCase {
    private CollectionService collectionService;

    public GetCollectionDetailUseCase(Gson gson, CollectionService collectionService) {
        super(gson);
        this.collectionService = collectionService;
    }

    public Observable<Response<GetCollectionDetailQuery.Data>> execute(int id, String language) {
        return collectionService.getCollectionDetail(id, language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}
