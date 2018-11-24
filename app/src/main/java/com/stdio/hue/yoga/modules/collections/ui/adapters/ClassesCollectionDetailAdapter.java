package com.stdio.hue.yoga.modules.collections.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.databinding.ItemClassesCollectionDetailBinding;
import com.stdio.hue.yoga.modules.collections.models.FilterClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 11/23/18.
 */
public class ClassesCollectionDetailAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<FilterClasses> items;
    private ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener listener;

    public ClassesCollectionDetailAdapter(ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener listener) {
        super(null);
        this.listener = listener;
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_classes_collection_detail;
    }

    public void updateData(List<FilterClasses> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemClassesCollectionDetailBinding) {
            ItemClassesCollectionDetailBinding itemBind = (ItemClassesCollectionDetailBinding) binding;
            FilterClasses filterClasses = items.get(position);
            itemBind.setTitle(filterClasses.getTitle());
            ClassesOfCollectionAdapter adapter = new ClassesOfCollectionAdapter(listener);
            itemBind.rvClasses.hasFixedSize();
            itemBind.rvClasses.setAdapter(adapter);
            itemBind.rvClasses.setLayoutManager(new GridLayoutManager(itemBind.getRoot().getContext(), 2, LinearLayoutManager.VERTICAL, false));
            adapter.updateData(filterClasses.getClasses());
        }
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
