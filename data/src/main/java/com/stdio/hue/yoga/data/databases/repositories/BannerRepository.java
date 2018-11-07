package com.stdio.hue.yoga.data.databases.repositories;

import com.stdio.hue.yoga.data.models.Banner;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface BannerRepository {
    void insertBanner(List<Banner> banners);

    Flowable<List<Banner>> getAllBanner();
}
