package com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses.CollectionsClassesMainAdapter;
import com.stdio.hue.yoga.shares.utils.ViewUtils;

/**
 * Created by dungbeo on 1/3/2020.
 */
public class ItemCollectionClassMainVH extends RecyclerView.ViewHolder {
    private ItemCollectionClassesMainBinding binding;
    private CollectionsClassesMainAdapter.ItemCollectionsClassesMainClickListener listener;
    private Gson gson;


    public ItemCollectionClassMainVH(@NonNull ItemCollectionClassesMainBinding binding, Gson gson,CollectionsClassesMainAdapter.ItemCollectionsClassesMainClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.gson = gson;
        this.listener = listener;
    }

    public void bind(Collection collection){
        binding.setCollectionName(collection.getNameEntity(new Gson()).getNameLocale());
        binding.setCollectionAvatar(collection.getImage());
        binding.setTotalClasses(collection.getTotalClasses());
        ViewUtils.setOnDelayClick(binding.cvItemCollection, v -> listener.onItemCollectionClassesClick(collection));

    }
}
