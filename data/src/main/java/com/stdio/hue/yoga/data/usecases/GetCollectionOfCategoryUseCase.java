package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetCollectionsOfACategoryQuery;
import com.stdio.hue.yoga.network.service.CollectionService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetCollectionOfCategoryUseCase extends BaseUseCase {
    private CollectionService collectionService;

    public GetCollectionOfCategoryUseCase(Gson gson, CollectionService collectionService) {
        super(gson);
        this.collectionService = collectionService;
    }

    public Observable<Response<GetCollectionsOfACategoryQuery.Data>> execute(int limit, int page, int categoryId, String where, String language) {
        return collectionService.getCollectionsOfACategory(limit, page, categoryId, where, language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}
