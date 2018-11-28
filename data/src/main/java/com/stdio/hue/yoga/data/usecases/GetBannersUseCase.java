package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.BannerMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetBannersUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private BannerMapper bannerMapper;

    public GetBannersUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, BannerMapper bannerMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.bannerMapper = bannerMapper;
    }

    public Observable<BaseResponse<List<Banner>>> execute(String timeUpdate, String language) {
        return dataService.getBanners(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Banner>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Banner>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(bannerMapper.transform(dataResponse.data().banner()));
                        return baseResponse;
                    }
                });
    }
}
