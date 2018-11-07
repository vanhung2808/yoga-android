package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.data.mappers.BannerMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
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
    private BannerRepository bannerRepository;

    public GetBannersUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, BannerMapper bannerMapper, BannerRepository bannerRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.bannerMapper = bannerMapper;
        this.bannerRepository = bannerRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getBanners(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        //Notify error
                        return false;
                    } else {
                        //Mapper data
                        List<Banner> banners = bannerMapper.transform(dataResponse.data().banner());
                        //Save local
                        bannerRepository.insertBanner(banners);
                        return true;
                    }
                });
    }
}
