package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.News;

import java.util.List;

/**
 * Created by DucPham on 28/11/2018.
 */
public interface NewsRepository {
    List<News> getAllNews();
    void insertNews(List<News> news);
    void updateNews(News news);
}
