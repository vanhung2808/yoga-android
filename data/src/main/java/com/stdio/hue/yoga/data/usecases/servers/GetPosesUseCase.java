package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.PosesRepository;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.PosesMapper;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetPosesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private PosesMapper posesMapper;
    private PosesRepository posesRepository;

    public GetPosesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, PosesMapper posesMapper, PosesRepository posesRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.posesMapper = posesMapper;
        this.posesRepository = posesRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getPoses(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Poses> poses = posesMapper.transform(dataResponse.data().pose());
                        //Save local
                        posesRepository.insertPoses(poses);
                        return true;
                    }
                });
    }
}
