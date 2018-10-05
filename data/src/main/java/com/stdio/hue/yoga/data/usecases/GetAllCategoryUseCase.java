package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetAllCategoryQuery;
import com.stdio.hue.yoga.network.service.CategoryService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetAllCategoryUseCase extends BaseUseCase {
    private CategoryService categoryService;

    public GetAllCategoryUseCase(Gson gson, CategoryService categoryService) {
        super(gson);
        this.categoryService = categoryService;
    }

    public Observable<Response<GetAllCategoryQuery.Data>> execute(String language) {
        return categoryService.getAllCategory(language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}