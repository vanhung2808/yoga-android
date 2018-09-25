package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.BannerQuery;
import com.stdio.hue.yoga.network.service.BannerService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class GetBannersUseCase extends BaseUseCase {
    private BannerService bannerService;

    public GetBannersUseCase(Gson gson, BannerService bannerService) {
        super(gson);
        this.bannerService = bannerService;
    }

    public Observable<Response<BannerQuery.Data>> execute(String language) {
        return bannerService.getBanners(language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}
