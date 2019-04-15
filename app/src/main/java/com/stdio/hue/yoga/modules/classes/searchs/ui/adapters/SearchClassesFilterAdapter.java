package com.stdio.hue.yoga.modules.classes.searchs.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.ItemSearchClassesFilterBinding;
import com.stdio.hue.yoga.databinding.ItemSearchFooterBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesFilterAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private static final int TYPE_FILTER = 1;
    private static final int TYPE_FOOTER = 2;
    private static final int TOTAL_ITEM = 5;
    private List<BaseFilter> durations, abilities, focuses, intensities;
    private boolean durationHasSelected, abilityHasSelected, focusHasSelected, intensityHasSelected;
    private FilterAdapter durationFilterAdapter, abilityFilterAdapter, focusFilterAdapter, intensityFilterAdapter;
    private SearchClassesFilterAdapterListener listener;

    public SearchClassesFilterAdapter(SearchClassesFilterAdapterListener listener) {
        super(null);
        this.listener = listener;
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
        if (viewType == TYPE_FILTER) {
            return R.layout.item_search_classes_filter;
        } else {
            return R.layout.item_search_footer;
        }
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemSearchClassesFilterBinding) {
            ItemSearchClassesFilterBinding itemBind = (ItemSearchClassesFilterBinding) binding;
            itemBind.rvFilter.setLayoutManager(new GridLayoutManager(itemBind.getRoot().getContext(), 3, LinearLayoutManager.VERTICAL, false));
            if (position == 0) {
                itemBind.tvTypeFilter.setText(R.string.duration_filter);
                durationFilterAdapter.addData(durations);
                itemBind.rvFilter.setAdapter(durationFilterAdapter);
            } else if (position == 1) {
                itemBind.tvTypeFilter.setText(R.string.ability_filter);
                abilityFilterAdapter.addData(abilities);
                itemBind.rvFilter.setAdapter(abilityFilterAdapter);
            } else if (position == 2) {
                itemBind.tvTypeFilter.setText(R.string.focus_filter);
                focusFilterAdapter.addData(focuses);
                itemBind.rvFilter.setAdapter(focusFilterAdapter);
            } else {
                itemBind.tvTypeFilter.setText(R.string.intensity_filter);
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
        } else if (binding instanceof ItemSearchFooterBinding) {
            ItemSearchFooterBinding itemBind = (ItemSearchFooterBinding) binding;
            itemBind.btSearch.setOnClickListener(v -> listener.onSearchClick());
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
        return TOTAL_ITEM;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == TOTAL_ITEM - 1) {
            return TYPE_FOOTER;
        }
        return TYPE_FILTER;
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

    public interface SearchClassesFilterAdapterListener {
        void onSearchClick();
    }
}
