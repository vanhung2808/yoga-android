package com.stdio.hue.yoga.modules.collections.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.ItemClassesBinding;
import com.stdio.hue.yoga.modules.collections.ui.adapters.viewholder.ItemClassesOfCollectionVH;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 11/24/18.
 */
public class ClassesOfCollectionAdapter extends RecyclerView.Adapter<ItemClassesOfCollectionVH> {
    private static final int TYPE_LEFT = 110;
    private static final int TYPE_RIGHT = 111;

    private List<Classes> classes;
    private ClassesOfCollectionAdapterListener listener;
    private Gson gson;

    public ClassesOfCollectionAdapter(ClassesOfCollectionAdapterListener listener) {
        this.classes = new ArrayList<>();
        this.listener = listener;
        this.gson = new Gson();
    }

    @NonNull
    @Override
    public ItemClassesOfCollectionVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemClassesBinding binding = ItemClassesBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        int with = viewGroup.getMeasuredWidth() / 2;
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(with, (int) (with * (i == TYPE_LEFT ? 1.5 : 1.7))));
        return new ItemClassesOfCollectionVH(binding, gson, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemClassesOfCollectionVH itemClassesOfCollectionVH, int i) {
        itemClassesOfCollectionVH.bind(classes.get(i));
    }

    public void updateData(List<Classes> classes) {
        if (this.classes == null) {
            this.classes = new ArrayList<>();
        }
        int size = classes.size();
        this.classes.addAll(classes);
        this.classes.addAll(classes);
        this.classes.addAll(classes);
        notifyItemRangeInserted(size, classes.size());
    }

    private Uri getExitsVideo(Context context, String videoName) {
        File file = new File(context.getFilesDir(), videoName);
        if (file.exists()) {
            return Uri.parse(file.getPath());
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return classes == null ? 0 : classes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position != 1 ? TYPE_LEFT : TYPE_RIGHT;
    }

    public interface ClassesOfCollectionAdapterListener {
        void onItemClassesClick(Classes classes);
    }
}
