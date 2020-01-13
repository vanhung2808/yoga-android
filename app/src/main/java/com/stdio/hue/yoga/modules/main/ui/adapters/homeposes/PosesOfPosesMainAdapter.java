package com.stdio.hue.yoga.modules.main.ui.adapters.homeposes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databinding.ItemPosesBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeposes.viewholder.ItemPosesOfPosesMainVH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dungbeo on 1/12/2020.
 */
public class PosesOfPosesMainAdapter extends RecyclerView.Adapter<ItemPosesOfPosesMainVH> {

    private List<Poses> poses;
    private static final int TYPE_LEFT = 110;
    private static final int TYPE_RIGHT = 111;
    private ItemPosesClickListener listener;
    private Gson gson;

    public PosesOfPosesMainAdapter(ItemPosesClickListener listener) {
        poses = new ArrayList<>();
        this.listener = listener;
        this.gson = new GsonBuilder().create();
    }

    @NonNull
    @Override
    public ItemPosesOfPosesMainVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPosesBinding itemPosesBinding = ItemPosesBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        int with = viewGroup.getMeasuredWidth() / 2;
        itemPosesBinding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(with, (int) ((with) * (i == TYPE_LEFT ? 1.5 : 1.7))));
        return new ItemPosesOfPosesMainVH(listener, itemPosesBinding, gson);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPosesOfPosesMainVH itemPosesOfPosesMainVH, int i) {
        itemPosesOfPosesMainVH.bind(poses.get(i));
    }

    public void updateData(List<Poses> poses) {
        int size = poses.size();
        this.poses.addAll(poses);
        notifyItemRangeInserted(size, poses.size());
    }

    @Override
    public int getItemCount() {
        return poses != null ? poses.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position != 1 ? TYPE_LEFT : TYPE_RIGHT;
    }

    public interface ItemPosesClickListener {
        void onItemPosesClickListener(Poses poses);
    }
}
