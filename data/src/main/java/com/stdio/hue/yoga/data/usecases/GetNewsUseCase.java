package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.NewsMapper;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DucPham on 28/11/2018.
 */
public class GetNewsUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private NewsMapper newsMapper;

    public GetNewsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, NewsMapper newsMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.newsMapper = newsMapper;
    }

    public Observable<BaseResponse<List<News>>> execute(String timeUpdate, String language) {
        return dataService.getNews(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<News>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<News>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(newsMapper.transform(dataResponse.data().postAll()));
                        return baseResponse;
                    }
                });
    }
}
