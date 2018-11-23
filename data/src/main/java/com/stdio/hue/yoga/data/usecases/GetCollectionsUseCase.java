package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.CollectionMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetCollectionsUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private CollectionMapper collectionMapper;

    public GetCollectionsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CollectionMapper collectionMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.collectionMapper = collectionMapper;
    }

    public Observable<BaseResponse<List<Collection>>> execute(Integer timeUpdate, String language) {
        return dataService.getCollections(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Collection>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Collection>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(collectionMapper.transform(dataResponse.data().collections()));
                        return baseResponse;
                    }
                });
    }
}
