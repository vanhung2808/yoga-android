package com.stdio.hue.yoga.databases.repositories;

import com.stdio.hue.yoga.data.models.Category;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public interface CategoryRepository {
    void insertCategory(List<Category> categories);

    List<Category> getAllCategory();
}
