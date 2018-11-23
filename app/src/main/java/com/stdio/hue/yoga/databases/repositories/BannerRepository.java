package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Banner;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface BannerRepository {
    void insertBanner(List<Banner> banners);

    List<Banner> getAllBanner();
}
