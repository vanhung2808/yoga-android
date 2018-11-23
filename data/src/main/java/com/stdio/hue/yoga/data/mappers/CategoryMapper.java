package com.stdio.hue.yoga.data.mappers;

import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.network.GetCategoryQuery;

/**
 * Created by TranHuuPhuc on 11/7/18.
 */
public class CategoryMapper extends Mapper<GetCategoryQuery.Category, Category> {
    @Override
    public Category transform(GetCategoryQuery.Category entity) {
        Category category = null;
        if (entity != null) {
            category = new Category();
            category.setId(entity.id());
            category.setName(entity.name());
            category.setCreatedAt(String.valueOf(entity.created_at()));
            category.setUpdatedAt(String.valueOf(entity.updated_at()));
        }
        return category;
    }
}
