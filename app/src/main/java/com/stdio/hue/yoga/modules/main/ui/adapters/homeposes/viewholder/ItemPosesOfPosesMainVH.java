package com.stdio.hue.yoga.modules.main.ui.adapters.homeposes.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databinding.ItemPosesBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeposes.PosesOfPosesMainAdapter;
import com.stdio.hue.yoga.shares.utils.ViewUtils;

/**
 * Created by dungbeo on 1/12/2020.
 */
public class ItemPosesOfPosesMainVH extends RecyclerView.ViewHolder {

    private PosesOfPosesMainAdapter.ItemPosesClickListener listener;
    private ItemPosesBinding posesBinding;
    private Gson gson;

    public ItemPosesOfPosesMainVH(@NonNull PosesOfPosesMainAdapter.ItemPosesClickListener listener, ItemPosesBinding binding, Gson gson) {
        super(binding.getRoot());
        this.listener = listener;
        this.posesBinding = binding;
        this.gson = gson;
    }

    public void bind(Poses poses) {
        posesBinding.setPosesName(poses.getNameEntity(new Gson()).getNameLocale());
        posesBinding.setPosesImage(poses.getImage());

        ViewUtils.setOnDelayClick(posesBinding.getRoot(), view -> {
            listener.onItemPosesClickListener(poses);
        });

    }
}
