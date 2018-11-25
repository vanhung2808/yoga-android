package com.stdio.hue.yoga.modules.collections.ui.adapters;

import android.databinding.ViewDataBinding;

import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.ItemClassesBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class ClassesOfCollectionAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<Classes> items;
    private ClassesOfCollectionAdapterListener listener;

    public ClassesOfCollectionAdapter(ClassesOfCollectionAdapterListener listener) {
        super(null);
        this.listener = listener;
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_classes;
    }

    public void updateData(List<Classes> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemClassesBinding) {
            ItemClassesBinding itemBind = (ItemClassesBinding) binding;
            Classes classes = items.get(position);
            itemBind.setClassesImage(classes.getImage());
            itemBind.setClassesName(classes.getNameEntity(getGson()).getNameLocale());
            itemBind.setClassesTime(classes.getDuration());
            itemBind.cvContent.setOnClickListener(view -> {
                listener.onItemClassesClick(classes);
            });
        }
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public interface ClassesOfCollectionAdapterListener {
        void onItemClassesClick(Classes classes);
    }
}
