package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetCategoryDetailQuery;
import com.stdio.hue.yoga.network.service.CategoryService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetCategoryDetailUseCase extends BaseUseCase {
    private CategoryService categoryService;

    public GetCategoryDetailUseCase(Gson gson, CategoryService categoryService) {
        super(gson);
        this.categoryService = categoryService;
    }

    public Observable<Response<GetCategoryDetailQuery.Data>> execute(int id, boolean includeCollection, String language) {
        return categoryService.getCategoryDetail(id, includeCollection, language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}