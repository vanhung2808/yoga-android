package com.stdio.hue.yoga.di.components;

import com.stdio.hue.yoga.ProjectApplication;
import com.stdio.hue.yoga.di.modules.AppModule;
import com.stdio.hue.yoga.modules.classes.detail.di.ClassesDetailComponent;
import com.stdio.hue.yoga.modules.classes.searchs.di.SearchClassesComponent;
import com.stdio.hue.yoga.modules.collections.di.CollectionDetailComponent;
import com.stdio.hue.yoga.modules.main.di.MainComponent;
import com.stdio.hue.yoga.modules.poses.detail.di.PosesDetailComponent;
import com.stdio.hue.yoga.modules.splash.di.SplashComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(ProjectApplication projectApplication);

        AppComponent build();
    }

    void inject(ProjectApplication projectApplication);

    SplashComponent getSplashComponent();

    MainComponent getMainComponent();

    CollectionDetailComponent getCollectionDetailComponent();

    SearchClassesComponent getSearchClassesComponent();

    ClassesDetailComponent getClassesDetailComponent();

    PosesDetailComponent getPosesDetailComponent();
}
