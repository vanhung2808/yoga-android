package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.FocusMapper;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetFocusUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private FocusMapper focusMapper;

    public GetFocusUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, FocusMapper focusMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.focusMapper = focusMapper;
    }

    public Observable<BaseResponse<List<Focus>>> execute(Integer timeUpdate, String language) {
        return dataService.getFocus(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Focus>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Focus>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(focusMapper.transform(dataResponse.data().viewAllFocus()));
                        return baseResponse;
                    }
                });
    }
}
