package com.stdio.hue.yoga.modules.splash.di;

import com.stdio.hue.yoga.data.usecases.servers.GetAbilitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetBannersUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCategoriesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetClassesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetCollectionsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetDurationsUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetFocusUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetIntensitiesUseCase;
import com.stdio.hue.yoga.data.usecases.servers.GetPosesUseCase;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenter;
import com.stdio.hue.yoga.modules.splash.presenter.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hung.nguyendk on 4/29/18.
 */
@Module
public class SplashModule {
    @Provides
    public SplashPresenter providesSplashPresenter(GetAbilitiesUseCase getAbilitiesUseCase, GetBannersUseCase getBannersUseCase, GetCategoriesUseCase getCategoriesUseCase, GetClassesUseCase getClassesUseCase, GetCollectionsUseCase getData, GetDurationsUseCase getDurationsUseCase, GetFocusUseCase getFocusUseCase, GetIntensitiesUseCase getIntensitiesUseCase, GetPosesUseCase getPosesUseCase) {
        return new SplashPresenterImpl(getAbilitiesUseCase, getBannersUseCase, getCategoriesUseCase, getClassesUseCase, getData, getDurationsUseCase, getFocusUseCase, getIntensitiesUseCase, getPosesUseCase);
    }
}
