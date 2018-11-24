package com.stdio.hue.yoga.modules.classes.searchs.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.ItemSearchClassesFilterBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesFilterAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<BaseFilter> durations, abilities, focuses, intensities;
    private boolean durationHasSelected, abilityHasSelected, focusHasSelected, intensityHasSelected;
    private FilterAdapter durationFilterAdapter, abilityFilterAdapter, focusFilterAdapter, intensityFilterAdapter;

    public SearchClassesFilterAdapter() {
        super(null);
        durations = new ArrayList<>();
        abilities = new ArrayList<>();
        focuses = new ArrayList<>();
        intensities = new ArrayList<>();
        durationHasSelected = false;
        abilityHasSelected = false;
        focusHasSelected = false;
        intensityHasSelected = false;
        durationFilterAdapter = new FilterAdapter();
        abilityFilterAdapter = new FilterAdapter();
        focusFilterAdapter = new FilterAdapter();
        intensityFilterAdapter = new FilterAdapter();
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_search_classes_filter;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemSearchClassesFilterBinding) {
            ItemSearchClassesFilterBinding itemBind = (ItemSearchClassesFilterBinding) binding;
            itemBind.rvFilter.setLayoutManager(new GridLayoutManager(itemBind.getRoot().getContext(), 3, LinearLayoutManager.VERTICAL, false));
            if (position == 0) {
                itemBind.tvTypeFilter.setText("DurationEntity");
                durationFilterAdapter.addData(durations);
                itemBind.rvFilter.setAdapter(durationFilterAdapter);
            } else if (position == 1) {
                itemBind.tvTypeFilter.setText("AbilityEntity");
                abilityFilterAdapter.addData(abilities);
                itemBind.rvFilter.setAdapter(abilityFilterAdapter);
            } else if (position == 2) {
                itemBind.tvTypeFilter.setText("FocusEntity");
                focusFilterAdapter.addData(focuses);
                itemBind.rvFilter.setAdapter(focusFilterAdapter);
            } else {
                itemBind.tvTypeFilter.setText("IntensityEntity");
                intensityFilterAdapter.addData(intensities);
                itemBind.rvFilter.setAdapter(intensityFilterAdapter);
            }
            itemBind.flTitle.setOnClickListener(view -> {
                if (itemBind.rvFilter.getVisibility() == View.VISIBLE) {
                    itemBind.rvFilter.setVisibility(View.GONE);
                    itemBind.ivExpand.setRotation(360);
                } else {
                    itemBind.rvFilter.setVisibility(View.VISIBLE);
                    itemBind.ivExpand.setRotation(90);
                }
            });
        }
    }

    public void updateData(List<Object> filters) {
        abilities.clear();
        durations.clear();
        focuses.clear();
        intensities.clear();
        abilities.addAll((Collection<? extends BaseFilter>) filters.get(0));
        durations.addAll((Collection<? extends BaseFilter>) filters.get(1));
        focuses.addAll((Collection<? extends BaseFilter>) filters.get(2));
        intensities.addAll((Collection<? extends BaseFilter>) filters.get(3));
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public void clearAllSelector() {
        durationHasSelected = false;
        abilityHasSelected = false;
        focusHasSelected = false;
        intensityHasSelected = false;
        clearAll(durations);
        clearAll(abilities);
        clearAll(focuses);
        clearAll(intensities);
    }

    private void clearAll(List<BaseFilter> items) {
        for (BaseFilter baseFilter : items) {
            baseFilter.setChecked(false);
        }
    }

    public List<BaseFilter> getFilterAbility() {
        return abilities;
    }

    public List<BaseFilter> getFilterDuration() {
        return durations;
    }

    public List<BaseFilter> getFilterFocus() {
        return focuses;
    }

    public List<BaseFilter> getFilterIntensity() {
        return intensities;
    }

    public boolean getHasSelectedFilterAbility() {
        return durationFilterAdapter.hasSelected();
    }

    public boolean getHasSelectedFilterDuration() {
        return abilityFilterAdapter.hasSelected();
    }

    public boolean getHasSelectedFilterFocus() {
        return focusFilterAdapter.hasSelected();
    }

    public boolean getHasSelectedFilterIntensity() {
        return intensityFilterAdapter.hasSelected();
    }
}
