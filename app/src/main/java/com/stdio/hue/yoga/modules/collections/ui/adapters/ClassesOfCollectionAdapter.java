package com.stdio.hue.yoga.modules.collections.ui.adapters;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.databinding.ItemClassesBinding;
import com.stdio.hue.yoga.shares.utils.ConvertJsonToNameEntity;

import java.io.File;
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
            if (getExitsVideo(itemBind.getRoot().getContext(), "classes" + classes.getId() + ".mp4") == null) {
                itemBind.ivStatusDownload.setVisibility(View.GONE);
            } else {
                itemBind.ivStatusDownload.setVisibility(View.VISIBLE);
            }
            itemBind.setClassesImage(classes.getImage());
            itemBind.setClassesName(classes.getNameEntity(getGson()).getNameLocale());
            itemBind.setClassesTime(ConvertJsonToNameEntity.getNameEntity(getGson(), classes.getDuration()).getNameLocale());
            itemBind.cvContent.setOnClickListener(view -> {
                listener.onItemClassesClick(classes);
            });
        }
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
        return items == null ? 0 : items.size();
    }

    public interface ClassesOfCollectionAdapterListener {
        void onItemClassesClick(Classes classes);
    }
}
