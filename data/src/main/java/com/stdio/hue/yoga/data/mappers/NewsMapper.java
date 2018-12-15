package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.network.GetNewsQuery;

/**
 * Created by DucPham on 28/11/2018.
 */
public class NewsMapper extends Mapper<GetNewsQuery.PostAll, News>{
    @Override
    public News transform(GetNewsQuery.PostAll entity) {
        News news = null;
        if(entity != null){
            news = new News();
            news.setId(entity.id());
            news.setTitle(entity.title());
            news.setImage(entity.image());
            news.setContent(entity.content());
            news.setTotalFavorite(entity.like_post());
            news.setCreatedAt(String.valueOf(entity.created_at()));
            news.setUpdatedAt(String.valueOf(entity.updated_at()));
        }
        return news;
    }
}
