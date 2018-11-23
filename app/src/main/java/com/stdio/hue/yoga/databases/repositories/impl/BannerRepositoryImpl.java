package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databases.daos.BannerDao;
import com.stdio.hue.yoga.databases.daos.CollectionDao;
import com.stdio.hue.yoga.databases.repositories.BannerRepository;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class BannerRepositoryImpl implements BannerRepository {
    private final BannerDao bannerDao;
    private final CollectionDao collectionDao;

    public BannerRepositoryImpl(BannerDao bannerDao, CollectionDao collectionDao) {
        this.bannerDao = bannerDao;
        this.collectionDao = collectionDao;
    }

    @Override
    public void insertBanner(List<Banner> banners) {
        for (Banner banner : banners) {
            bannerDao.insertBanner(banner);
        }
    }

    @Override
    public List<Banner> getAllBanner() {
        List<Banner> banners = bannerDao.getAll();
        for (Banner banner : banners) {
            Collection collection = collectionDao.getCollection(Integer.parseInt(banner.getCollectionId()));
            banner.setCollection(collection);
        }
        return banners;
    }
}
