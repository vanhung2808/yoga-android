package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.network.GetBannerQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class BannerMapper extends Mapper<GetBannerQuery.Banner, Banner> {
    @Override
    public Banner transform(GetBannerQuery.Banner entity) {
        Banner banner = null;
        if (entity != null) {
            banner = new Banner();
            banner.setId(entity.id());
            banner.setImage(entity.image());
            banner.setType(String.valueOf(entity.type()));
            banner.setUrl(entity.url());
            banner.setCollectionId(String.valueOf(entity.collection_id()));
            banner.setTitle(entity.title());
            banner.setTypeText(entity.type_text());
        }
        return banner;
    }
}
