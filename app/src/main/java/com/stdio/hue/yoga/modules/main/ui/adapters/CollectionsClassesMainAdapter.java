package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.databinding.ViewDataBinding;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;
import com.stdio.hue.yoga.network.GetCollectionsOfACategoryQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionsClassesMainAdapter extends AbsBindingAdapter<ItemCollectionClassesMainBinding> {
    private List<GetCollectionsOfACategoryQuery.Datum> collections;

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
            GetCollectionsOfACategoryQuery.Datum collection = collections.get(position);
            ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
            itemBind.setCollectionName(collection.name());
            itemBind.setCollectionAvatar(collection.image());
            itemBind.setTotalClasses(collection.classes() != null ? collection.classes().size() : 0);
        }
    }

    @Override
    public int getItemCount() {
        return collections != null ? collections.size() : 0;
    }

    public void updateData(List<GetCollectionsOfACategoryQuery.Datum> collections) {
        int size = collections.size();
        this.collections.addAll(collections);
        notifyItemRangeInserted(size, collections.size());
    }
}
