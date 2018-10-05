package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetClassesOfCollectionQuery;
import com.stdio.hue.yoga.network.service.ClassService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetClassesOfCollectionUseCase extends BaseUseCase {
    private ClassService classService;

    public GetClassesOfCollectionUseCase(Gson gson, ClassService classService) {
        super(gson);
        this.classService = classService;
    }

    public Observable<Response<GetClassesOfCollectionQuery.Data>> execute(int id, int page, int collectionId, String where, String language) {
        return classService.getClassesOfCollection(id, page, collectionId, where, language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}
