package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.IntensityMapper;
import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetIntensitiesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private IntensityMapper intensityMapper;

    public GetIntensitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, IntensityMapper intensityMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.intensityMapper = intensityMapper;
    }

    public Observable<BaseResponse<List<Intensity>>> execute(Integer timeUpdate, String language) {
        return dataService.getIntensities(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Intensity>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Intensity>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(intensityMapper.transform(dataResponse.data().viewAllIntensity()));
                        return baseResponse;
                    }
                });
    }
}
