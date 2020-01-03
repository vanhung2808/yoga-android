package com.stdio.hue.yoga.modules.collections.ui.adapters.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.ItemClassesBinding;
import com.stdio.hue.yoga.modules.collections.ui.adapters.ClassesOfCollectionAdapter;
import com.stdio.hue.yoga.shares.utils.ConvertJsonToNameEntity;

/**
 * Created by dungbeo on 1/3/2020.
 */
public class ItemClassesOfCollectionVH extends RecyclerView.ViewHolder {

    private Gson gson;
    private ItemClassesBinding binding;
    private ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener listener;

    public ItemClassesOfCollectionVH(@NonNull ItemClassesBinding binding, Gson gson, ClassesOfCollectionAdapter.ClassesOfCollectionAdapterListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.gson = gson;
        this.listener = listener;
    }

    public void bind(Classes classes){
        binding.setClassesName(classes.getNameEntity(new Gson()).getNameLocale());
        binding.setClassesTime(ConvertJsonToNameEntity.getNameEntity(new Gson(),classes.getDuration()).getNameLocale());
        binding.setClassesImage(classes.getImage());
        binding.getRoot().setOnClickListener(v -> {
            listener.onItemClassesClick(classes);
        });
    }
}
