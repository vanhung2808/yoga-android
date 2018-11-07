package com.stdio.hue.yoga.data.databases.repositories.impl;

import com.stdio.hue.yoga.data.databases.daos.CategoryDao;
import com.stdio.hue.yoga.data.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.data.models.Category;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class CategoryRepositoryImpl implements CategoryRepository {
    private CategoryDao categoryDao;

    public CategoryRepositoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void insertCategory(List<Category> categories) {
        Completable.fromAction(() -> categoryDao.insertAll(categories));

    }
}
