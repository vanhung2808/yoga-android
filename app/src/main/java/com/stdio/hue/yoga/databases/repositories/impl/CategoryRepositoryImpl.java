package com.stdio.hue.yoga.databases.repositories.impl;

import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.databases.daos.CategoryDao;
import com.stdio.hue.yoga.databases.repositories.CategoryRepository;

import java.util.List;

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
        for (Category category : categories) {
            categoryDao.insertCategory(category);
        }
    }
}
