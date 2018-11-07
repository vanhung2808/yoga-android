package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.FocusRepository;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.mappers.FocusMapper;
import com.stdio.hue.yoga.data.models.Focus;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetFocusUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private FocusMapper focusMapper;
    private FocusRepository focusRepository;

    public GetFocusUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, FocusMapper focusMapper, FocusRepository focusRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.focusMapper = focusMapper;
        this.focusRepository = focusRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getFocus(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Focus> focusList = focusMapper.transform(dataResponse.data().viewAllFocus());
                        //Save local
                        focusRepository.insertFocus(focusList);
                        return true;
                    }
                });
    }
}
