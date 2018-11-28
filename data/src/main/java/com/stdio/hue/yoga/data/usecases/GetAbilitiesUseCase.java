package com.stdio.hue.yoga.data.usecases;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.mappers.AbilityMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.models.base.BaseResponse;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetAbilitiesUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;
    private AbilityMapper abilityMapper;

    public GetAbilitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, AbilityMapper abilityMapper) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.abilityMapper = abilityMapper;
    }

    public Observable<BaseResponse<List<Ability>>> execute(String timeUpdate, String language) {
        return dataService.getAbilities(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        BaseResponse<List<Ability>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(dataResponse.hasErrors());
                        baseResponse.setErrors(errorMapper.transform(dataResponse.errors()));
                        baseResponse.setData(null);
                        return baseResponse;
                    } else {
                        BaseResponse<List<Ability>> baseResponse = new BaseResponse<>();
                        baseResponse.setHasError(false);
                        baseResponse.setErrors(null);
                        baseResponse.setData(abilityMapper.transform(dataResponse.data().viewAllAbility()));
                        return baseResponse;
                    }
                });
    }
}
