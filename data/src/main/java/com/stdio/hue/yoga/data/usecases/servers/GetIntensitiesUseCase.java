package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.IntensityRepository;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.IntensityMapper;
import com.stdio.hue.yoga.data.models.Intensity;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetIntensitiesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private IntensityMapper intensityMapper;
    private IntensityRepository intensityRepository;

    public GetIntensitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, IntensityMapper intensityMapper, IntensityRepository intensityRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.intensityMapper = intensityMapper;
        this.intensityRepository = intensityRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getIntensities(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Intensity> intensities = intensityMapper.transform(dataResponse.data().viewAllIntensity());
                        //Save local
                        intensityRepository.insertIntensity(intensities);
                        return true;
                    }
                });
    }
}
