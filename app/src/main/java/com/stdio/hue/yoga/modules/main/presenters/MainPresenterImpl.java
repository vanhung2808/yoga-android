package com.stdio.hue.yoga.modules.main.presenters;

import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.data.usecases.GetBannersUseCase;
import com.stdio.hue.yoga.modules.main.ui.actions.MainAction;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
    private GetBannersUseCase getBannersUseCase;
    private PublishSubject<MainAction> mainActionState;

    public MainPresenterImpl(GetBannersUseCase getBannersUseCase, PublishSubject<MainAction> mainActionState) {
        this.getBannersUseCase = getBannersUseCase;
        this.mainActionState = mainActionState;
    }

    @Override
    public void getBanners() {
        disposable.add(getBannersUseCase.execute("vi")
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> mainActionState.onNext(MainAction.isLoading(true)))
                .doOnError(throwable -> mainActionState.onNext(MainAction.isLoading(false)))
                .doOnComplete(() -> mainActionState.onNext(MainAction.isLoading(false)))
                .subscribe(baseResponse -> {
                    if (baseResponse.hasErrors()) {
                        mainActionState.onNext(MainAction.error(baseResponse.errors().get(0).message()));
                    } else {
                        if (baseResponse.data() != null && baseResponse.data().banner() != null && !baseResponse.data().banner().isEmpty()) {
                            mainActionState.onNext(MainAction.setBanners(baseResponse.data().banner()));
                        }
                    }
                }, throwable -> mainActionState.onNext(MainAction.error(throwable.getMessage()))));
    }
}
