package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.BannerDao;
import com.stdio.hue.yoga.data.databases.repositories.BannerRepository;
import com.stdio.hue.yoga.data.models.Banner;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class BannerRepositoryImpl implements BannerRepository {
    private BannerDao bannerDao;

    public BannerRepositoryImpl(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
    }

    @Override
    public void insertBanner(List<Banner> banners) {
        Completable.fromAction(() -> bannerDao.insertAll(banners));
    }

    @Override
    public Flowable<List<Banner>> getAllBanner() {
        return bannerDao.getAll();
    }
}
