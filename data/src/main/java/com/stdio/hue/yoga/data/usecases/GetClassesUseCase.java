package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.ClassesMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetClassesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private ClassesMapper classesMapper;

    public GetClassesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, ClassesMapper classesMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.classesMapper = classesMapper;
    }

    public Observable<BaseResponse<List<Classes>>> execute(Integer timeUpdate, String language) {
        return dataService.getClasses(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Classes>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Classes>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(classesMapper.transform(dataResponse.data().classes()));
                        return baseResponse;
                    }
                });
    }
}
