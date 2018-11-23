package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.CategoryMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetCategoriesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private CategoryMapper categoryMapper;

    public GetCategoriesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CategoryMapper categoryMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.categoryMapper = categoryMapper;
    }

    public Observable<BaseResponse<List<Category>>> execute(Integer timeUpdate, String language) {
        return dataService.getCategories(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Category>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Category>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(categoryMapper.transform(dataResponse.data().categories()));
                        return baseResponse;
                    }
                });
    }
}
