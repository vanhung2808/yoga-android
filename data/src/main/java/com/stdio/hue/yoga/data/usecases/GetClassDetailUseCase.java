package com.stdio.hue.yoga.data.usecases;

import com.apollographql.apollo.api.Response;
import com.google.gson.Gson;
import com.stdio.hue.yoga.network.GetClassDetailQuery;
import com.stdio.hue.yoga.network.service.ClassService;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TranHuuPhuc on 9/26/18.
 */
public class GetClassDetailUseCase extends BaseUseCase {
    private ClassService classService;

    public GetClassDetailUseCase(Gson gson, ClassService classService) {
        super(gson);
        this.classService = classService;
    }

    public Observable<Response<GetClassDetailQuery.Data>> execute(int id, String language) {
        return classService.getClassDetail(id, language)
                .subscribeOn(Schedulers.io())
                .map(response -> response);
    }
}
