package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.DurationRepository;
import com.stdio.hue.yoga.data.mappers.DurationMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Duration;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetDurationsUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;

    private DurationMapper durationMapper;

    private DurationRepository durationRepository;

    public GetDurationsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, DurationMapper durationMapper, DurationRepository durationRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.durationMapper = durationMapper;
        this.durationRepository = durationRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getDurations(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Duration> durations = durationMapper.transform(dataResponse.data().viewAllDuration());
                        //Save local
                        durationRepository.insertDuration(durations);
                        return true;
                    }
                });
    }
}
