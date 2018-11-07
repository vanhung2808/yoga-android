package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.AbilityRepository;
import com.stdio.hue.yoga.data.mappers.AbilityMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Ability;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
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

    private AbilityRepository abilityRepository;

    public GetAbilitiesUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, AbilityMapper abilityMapper, AbilityRepository abilityRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.abilityMapper = abilityMapper;
        this.abilityRepository = abilityRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getAbilities(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Ability> abilities = abilityMapper.transform(dataResponse.data().viewAllAbility());
                        //Save local
                        abilityRepository.insertAbility(abilities);
                        return true;
                    }
                });
    }
}
