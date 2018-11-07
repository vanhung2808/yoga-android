package com.stdio.hue.yoga.data.usecases.servers;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.databases.repositories.CollectionRepository;
import com.stdio.hue.yoga.data.mappers.CollectionMapper;
import com.stdio.hue.yoga.data.mappers.ErrorMapper;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.data.usecases.BaseUseCase;
import com.stdio.hue.yoga.network.service.DataService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 11/8/18.
 */
public class GetCollectionsUseCase extends BaseUseCase {
    private DataService dataService;
    private ErrorMapper errorMapper;

    private CollectionMapper collectionMapper;

    private CollectionRepository collectionRepository;

    public GetCollectionsUseCase(Gson gson, DataService dataService, ErrorMapper errorMapper, CollectionMapper collectionMapper, CollectionRepository collectionRepository) {
        super(gson);
        this.dataService = dataService;
        this.errorMapper = errorMapper;
        this.collectionMapper = collectionMapper;
        this.collectionRepository = collectionRepository;
    }

    public Observable<Boolean> execute(Integer timeUpdate, String language) {
        return dataService.getCollections(timeUpdate, language)
                .subscribeOn(Schedulers.io())
                .map(dataResponse -> {
                    if (dataResponse.hasErrors()) {
                        return false;
                    } else {
                        //Mapper data
                        List<Collection> collections = collectionMapper.transform(dataResponse.data().collections());
                        //Save local
                        collectionRepository.insertCollection(collections);
                        return true;
                    }
                });
    }
}
