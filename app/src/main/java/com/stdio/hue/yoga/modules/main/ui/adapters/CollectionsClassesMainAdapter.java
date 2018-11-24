package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.databinding.ViewDataBinding;

import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionsClassesMainAdapter extends AbsBindingAdapter<ItemCollectionClassesMainBinding> {
    private List<Collection> collections;

    public CollectionsClassesMainAdapter(RecyclerViewClickListener itemListener) {
        super(itemListener);
        collections = new ArrayList<>();
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_collection_classes_main;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemCollectionClassesMainBinding) {
            Collection collection = collections.get(position);
            ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
            itemBind.setCollectionName(collection.getNameEntity(new GsonBuilder().create()).getNameLocale());
            itemBind.setCollectionAvatar(collection.getImage());
            itemBind.setTotalClasses(collection.getTotalClasses());
        }
    }

    public Collection getCollection(int position) {
        return collections.get(position);
    }

    @Override
    public int getItemCount() {
        return collections != null ? collections.size() : 0;
    }

    public void updateData(List<Collection> collections) {
        int size = collections.size();
        this.collections.addAll(collections);
        notifyItemRangeInserted(size, collections.size());
    }
}
