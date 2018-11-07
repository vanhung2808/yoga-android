package com.stdio.hue.yoga.data.usecases.locals;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetAllBannerLocalUseCase extends BaseUseCase {
    private BannerRepository bannerRepository;

    public GetAllBannerLocalUseCase(Gson gson, BannerRepository bannerRepository) {
        super(gson);
        this.bannerRepository = bannerRepository;
    }

    public Flowable<List<Banner>> execute() {
        return bannerRepository.getAllBanner();
    }
}
