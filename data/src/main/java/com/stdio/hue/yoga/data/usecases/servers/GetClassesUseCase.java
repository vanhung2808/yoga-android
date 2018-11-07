package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.ClassesRepository;
import com.stdio.hue.yoga.data.mappers.ClassesMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.models.Banner;
import com.stdio.hue.yoga.data.models.Category;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetClassesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private ClassesMapper classesMapper;

    private ClassesRepository classesRepository;

    public GetClassesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, ClassesMapper classesMapper, ClassesRepository classesRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.classesMapper = classesMapper;
        this.classesRepository = classesRepository;
    }
    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getClasses(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Classes> classes = classesMapper.transform(dataResponse.data().classes());
                        //Save local
                        classesRepository.insertClasses(classes);
                        return true;
                    }
                });
    }
}
