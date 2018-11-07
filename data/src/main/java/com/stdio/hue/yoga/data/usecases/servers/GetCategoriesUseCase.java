package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.CategoryRepository;
import com.stdio.hue.yoga.data.mappers.CategoryMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetCategoriesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    public GetCategoriesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getCategories(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        //Notify error
                        return false;
                    } else {
                        //Mapper data
                        List<Category> categories = categoryMapper.transform(dataResponse.data().categories());
                        //Save local
                        categoryRepository.insertCategory(categories);
                        return true;
                    }
                });
    }
}
