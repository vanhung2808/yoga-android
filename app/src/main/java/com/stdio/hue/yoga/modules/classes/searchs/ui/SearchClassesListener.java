package com.stdio.hue.yoga.modules.classes.searchs.ui;

import com.stdio.hue.yoga.data.models.base.BaseFilter;

import java.util.List;

/**
 * Created by TranHuuPhuc on 10/21/18.
 */
public interface SearchClassesListener {
    void onSearch(List<BaseFilter> filterAbility, List<BaseFilter> filterDuration, List<BaseFilter> filterFocus, List<BaseFilter> filterIntensity, boolean hasSelectedFilterAbility, boolean hasSelectedFilterDuration, boolean hasSelectedFilterFocus, boolean hasSelectedFilterIntensity);
}
