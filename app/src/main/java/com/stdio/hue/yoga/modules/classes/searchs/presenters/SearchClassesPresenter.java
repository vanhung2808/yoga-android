package com.stdio.hue.yoga.modules.classes.searchs.presenters;

import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.data.models.base.BaseFilter;

import java.util.List;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public interface SearchClassesPresenter extends Presenter {
    void getFilterData();

    void getClassesByIntensityId(List<BaseFilter> filterIntensity);

    void getClassesByFocusId(List<BaseFilter> filterFocus);

    void getClassesByDurationId(List<BaseFilter> filterDuration);

    void getClassesByAbilityId(List<BaseFilter> filterAbility);

    void getClassesResultFilter(int typeFilter, List<BaseFilter> baseFilters);
}
