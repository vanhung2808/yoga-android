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
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class SearchClassesFilterAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<BaseFilter> durations, abilities, focuses, intensities;

    public SearchClassesFilterAdapter() {
        super(null);
        durations = new ArrayList<>();
        abilities = new ArrayList<>();
        focuses = new ArrayList<>();
        intensities = new ArrayList<>();
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_search_classes_filter;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemSearchClassesFilterBinding) {
            ItemSearchClassesFilterBinding itemBind = (ItemSearchClassesFilterBinding) binding;
            FilterAdapter filterAdapter = new FilterAdapter();
            if (position == 0) {
                itemBind.tvTypeFilter.setText("DurationEntity");
                durations.add(new BaseFilter(1, "Any", false));
                durations.add(new BaseFilter(2, "0-20 mins", false));
                durations.add(new BaseFilter(3, "20-40 mins", false));
                durations.add(new BaseFilter(4, "40-60 mins", false));
                durations.add(new BaseFilter(5, "Over 60 mins", false));
                filterAdapter.addData(durations);
            } else if (position == 1) {
                itemBind.tvTypeFilter.setText("AbilityEntity");
                abilities.add(new BaseFilter(1, "Any", false));
                abilities.add(new BaseFilter(2, "Beginer", false));
                abilities.add(new BaseFilter(3, "Intermediate", false));
                abilities.add(new BaseFilter(4, "Advanced", false));
                filterAdapter.addData(abilities);
            } else if (position == 2) {
                itemBind.tvTypeFilter.setText("FocusEntity");
                focuses.add(new BaseFilter(1, "Any", false));
                focuses.add(new BaseFilter(2, "Combination", false));
                focuses.add(new BaseFilter(3, "Balance", false));
                focuses.add(new BaseFilter(4, "Flexibility", false));
                focuses.add(new BaseFilter(5, "Strength", false));
                focuses.add(new BaseFilter(6, "Relaxation", false));
                filterAdapter.addData(focuses);
            } else {
                itemBind.tvTypeFilter.setText("IntensityEntity");
                intensities.add(new BaseFilter(1, "Any", false));
                intensities.add(new BaseFilter(2, "Low", false));
                intensities.add(new BaseFilter(3, "Medium", false));
                intensities.add(new BaseFilter(4, "High", false));
                filterAdapter.addData(intensities);
            }
            itemBind.rvFilter.setLayoutManager(new GridLayoutManager(itemBind.getRoot().getContext(), 3, LinearLayoutManager.VERTICAL, false));
            itemBind.rvFilter.setAdapter(filterAdapter);
            itemBind.ivExpand.setOnClickListener(view -> {
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

    @Override
    public int getItemCount() {
        return 4;
    }

    public void clearAllSelector() {
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
}
