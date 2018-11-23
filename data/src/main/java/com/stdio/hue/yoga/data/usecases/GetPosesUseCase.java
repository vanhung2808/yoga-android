package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.PosesMapper;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetPosesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private PosesMapper posesMapper;

    public GetPosesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, PosesMapper posesMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.posesMapper = posesMapper;
    }

    public Observable<BaseResponse<List<Poses>>> execute(Integer timeUpdate, String language) {
        return dataService.getPoses(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Poses>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Poses>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(posesMapper.transform(dataResponse.data().pose()));
                        return baseResponse;
                    }
                });
    }
}
