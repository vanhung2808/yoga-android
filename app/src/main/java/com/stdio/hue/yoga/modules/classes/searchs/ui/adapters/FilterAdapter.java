package com.stdio.hue.yoga.modules.classes.searchs.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v4.content.ContextCompat;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.base.BaseFilter;
import com.stdio.hue.yoga.databinding.ItemFilterClassesBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/20/18.
 */
public class FilterAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<BaseFilter> items;

    public FilterAdapter() {
        super(null);
    }

    public void addData(List<BaseFilter> items) {
        if (items != null) {
            if (this.items == null) {
                this.items = new ArrayList<>();
            }
            this.items = items;
            notifyDataSetChanged();
        }
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_filter_classes;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemFilterClassesBinding) {
            ItemFilterClassesBinding itemBind = (ItemFilterClassesBinding) binding;
            BaseFilter baseFilter = items.get(position);
            itemBind.setFilter(baseFilter);
            itemBind.setName(baseFilter.getNameEntity(getGson()).getNameLocale());
            itemBind.cbFilter.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b) {
                    updateStateOfItem(baseFilter.getId());
                }
                baseFilter.setChecked(b);
                if (b) {
                    itemBind.cbFilter.setTextColor(ContextCompat.getColor(compoundButton.getContext(), R.color.colorWhite));
                } else {
                    itemBind.cbFilter.setTextColor(ContextCompat.getColor(compoundButton.getContext(), R.color.colorBlack));
                }
            });
        }
    }

    private void updateStateOfItem(int id) {
        for (BaseFilter baseFilter : items) {
            if (baseFilter.getId() != id) {
                baseFilter.setChecked(false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public boolean hasSelected() {
        boolean hasSelectedFilter = false;
        for (BaseFilter baseFilter : items) {
            if (baseFilter.isChecked()) {
                hasSelectedFilter = true;
                break;
            }
        }
        return hasSelectedFilter;
    }
}
