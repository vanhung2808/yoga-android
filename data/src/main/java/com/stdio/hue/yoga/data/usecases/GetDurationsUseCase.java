package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.DurationMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetDurationsUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private DurationMapper durationMapper;

    public GetDurationsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, DurationMapper durationMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.durationMapper = durationMapper;
    }

    public Observable<BaseResponse<List<Duration>>> execute(Integer timeUpdate, String language) {
        return dataService.getDurations(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Duration>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Duration>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(durationMapper.transform(dataResponse.data().viewAllDuration()));
                        return baseResponse;
                    }
                });
    }
}
