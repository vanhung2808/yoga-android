package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databases.daos.NewsDao;
import com.stdio.hue.yoga.databases.repositories.NewsRepository;

import java.util.List;

/**
 * Created by DucPham on 28/11/2018.
 */
public class NewsRepositoryImpl implements NewsRepository {
    private final NewsDao newsDao;

    public NewsRepositoryImpl(NewsDao newsDao){
        this.newsDao = newsDao;
    }

    @Override
    public List<News> getAllNews() {
        return newsDao.getAll();
    }

    @Override
    public void insertNews(List<News> news) {
        for (News item : news) {
            newsDao.insertNews(item);
        }
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNews(news);
    }


}
