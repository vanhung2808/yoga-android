package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.databinding.ViewDataBinding;

import com.stdio.hue.yoga.base.AbsBindingAdapter;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class ClassesMainAdapter extends AbsBindingAdapter<ViewDataBinding> {
    public ClassesMainAdapter() {
        super(null);
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return 0;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
