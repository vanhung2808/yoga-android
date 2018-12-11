package com.stdio.hue.yoga.modules.classes.detail.ui.adapters;

import android.databinding.ViewDataBinding;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databinding.ItemClassesDetailPosesBinding;
import com.stdio.hue.yoga.shares.utils.ConvertJsonToNameEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 12/5/18.
 */
public class ClassesDetailAdapter extends AbsBindingAdapter<ViewDataBinding> {
    private List<Poses> items;
    private ClassesDetailAdapterListener listener;

    public ClassesDetailAdapter(List<Poses> items, ClassesDetailAdapterListener listener) {
        super(null);
        this.listener = listener;
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_classes_detail_poses;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemClassesDetailPosesBinding) {
            ItemClassesDetailPosesBinding itemBind = (ItemClassesDetailPosesBinding) binding;
            Poses poses = items.get(position);
            itemBind.setPosesImage(poses.getImage());
            itemBind.setPosesName(poses.getNameEntity(getGson()).getNameLocale());
            itemBind.setPosesTime(ConvertJsonToNameEntity.getNameEntity(getGson(), poses.getDuration()).getNameLocale());
            itemBind.cvContent.setOnClickListener(view -> listener.onPosesClick(poses));
        }
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public interface ClassesDetailAdapterListener {
        void onPosesClick(Poses poses);
    }
}
