//package com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses;
//
//import android.databinding.ViewDataBinding;
//
//import com.stdio.hue.yoga.R;
//import com.stdio.hue.yoga.base.AbsBindingAdapter;
//import com.stdio.hue.yoga.data.models.Collection;
//import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by TranHuuPhuc on 10/5/18.
// */
//public class CollectionsClassesMainAdapter extends AbsBindingAdapter<ItemCollectionClassesMainBinding> {
//    private List<Collection> collections;
//
//    public CollectionsClassesMainAdapter(RecyclerViewClickListener itemListener) {
//        super(itemListener);
//        collections = new ArrayList<>();
//    }
//
//    @Override
//    protected int getLayoutResourceId(int viewType) {
//        return R.layout.item_collection_classes_main;
//    }
//
//    @Override
//    public void updateBinding(ViewDataBinding binding, int position) {
//        if (binding instanceof ItemCollectionClassesMainBinding) {
//            Collection collection = collections.get(position);
//            ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
//            itemBind.setCollectionName(collection.getNameEntity(getGson()).getNameLocale());
//            itemBind.setCollectionAvatar(collection.getImage());
//            itemBind.setTotalClasses(collection.getTotalClasses());
//        }
//    }
//
//    public Collection getCollection(int position) {
//        return collections.get(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return collections != null ? collections.size() : 0;
//    }
//
//    public void updateData(List<Collection> collections) {
//        int size = collections.size();
//        this.collections.addAll(collections);
//        notifyItemRangeInserted(size, collections.size());
//    }
//}

//package com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses;
//
//import android.databinding.ViewDataBinding;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.stdio.hue.yoga.R;
//import com.stdio.hue.yoga.base.AbsBindingAdapter;
//import com.stdio.hue.yoga.data.models.Collection;
//import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by TranHuuPhuc on 10/5/18.
// */
//public class CollectionsClassesMainAdapter extends RecyclerView.Adapter<CollecttionVH> {
//    private List<Collection> collections;
//
//    public CollectionsClassesMainAdapter(AbsBindingAdapter.RecyclerViewClickListener itemListener) {
////        super(itemListener);
//        collections = new ArrayList<>();
//    }
//
////    @Override
////    protected int getLayoutResourceId(int viewType) {
////        return R.layout.item_collection_classes_main;
////    }
////
////    @Override
////    public void updateBinding(ViewDataBinding binding, int position) {
////        if (binding instanceof ItemCollectionClassesMainBinding) {
////            Collection collection = collections.get(position);
////            ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
////            itemBind.setCollectionName(collection.getNameEntity(getGson()).getNameLocale());
////            itemBind.setCollectionAvatar(collection.getImage());
////            itemBind.setTotalClasses(collection.getTotalClasses());
////        }
////    }
//
//    public Collection getCollection(int position) {
//        return collections.get(position);
//    }
//
//    @NonNull
//    @Override
//    public CollecttionVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = ItemCollectionClassesMainBinding.inflate(LayoutInflater.from(viewGroup.getContext())).getRoot();
//        view.setLayoutParams(new ViewGroup.LayoutParams(StaggeredGridLayoutManager.LayoutParams.WRAP_CONTENT, StaggeredGridLayoutManager.LayoutParams.WRAP_CONTENT));
//        return new CollecttionVH(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CollecttionVH collecttionVH, int i) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return collections != null ? collections.size() : 0;
//    }
//
//    public void updateData(List<Collection> collections) {
//        int size = collections.size();
//        this.collections.addAll(collections);
//        notifyItemRangeInserted(size, collections.size());
//    }
//}
//
//class CollecttionVH extends RecyclerView.ViewHolder{
//
//    public CollecttionVH(@NonNull View itemView) {
//        super(itemView);
//    }
//}
//
////public class CollectionsClassesMainAdapter extends AbsBindingAdapter<ItemCollectionClassesMainBinding> {
////    private List<Collection> collections;
////
////    public CollectionsClassesMainAdapter(RecyclerViewClickListener itemListener) {
////        super(itemListener);
////        collections = new ArrayList<>();
////    }
////
////    @Override
////    protected int getLayoutResourceId(int viewType) {
////        return R.layout.item_collection_classes_main;
////    }
////
////    @Override
////    public void updateBinding(ViewDataBinding binding, int position) {
////        if (binding instanceof ItemCollectionClassesMainBinding) {
////            Collection collection = collections.get(position);
////            ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
////            itemBind.setCollectionName(collection.getNameEntity(getGson()).getNameLocale());
////            itemBind.setCollectionAvatar(collection.getImage());
////            itemBind.setTotalClasses(collection.getTotalClasses());
////        }
////    }
////
////    public Collection getCollection(int position) {
////        return collections.get(position);
////    }
////
////    @Override
////    public int getItemCount() {
////        return collections != null ? collections.size() : 0;
////    }
////
////    public void updateData(List<Collection> collections) {
////        int size = collections.size();
////        this.collections.addAll(collections);
////        notifyItemRangeInserted(size, collections.size());
////    }
////}
package com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.models.Collection;
import com.stdio.hue.yoga.databinding.ItemCollectionClassesMainBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homeclasses.viewholder.ItemCollectionClassMainVH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranHuuPhuc on 10/5/18.
 */
public class CollectionsClassesMainAdapter extends RecyclerView.Adapter<ItemCollectionClassMainVH> {
    private List<Collection> collections;
    private static final int TYPE_LEFT = 110;
    private static final int TYPE_RIGHT = 111;
    private ItemCollectionsClassesMainClickListener listener;
    private Gson gson;

    public CollectionsClassesMainAdapter(ItemCollectionsClassesMainClickListener listener) {
        collections = new ArrayList<>();
        this.gson = new GsonBuilder().create();
        this.listener = listener;
    }

//
//        @Override
//        public void updateBinding(ViewDataBinding binding, int position) {
//            if (binding instanceof ItemCollectionClassesMainBinding) {
////            if (position % 2 != 0) {
////                binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 1500));
////            } else {
////                binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
////            }
////            binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(binding.getRoot().getMeasuredWidth() / 2, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//                Collection collection = collections.get(position);
//                ItemCollectionClassesMainBinding itemBind = (ItemCollectionClassesMainBinding) binding;
//                itemBind.setCollectionName(collection.getNameEntity(getGson()).getNameLocale());
//                itemBind.setCollectionAvatar(collection.getImage());
//                itemBind.setTotalClasses(collection.getTotalClasses());
//            }
//            if (binding instanceof ItemCollectionClassesMainRightBinding) {
////            binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(binding.getRoot().getMeasuredWidth() / 2, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//                Collection collection = collections.get(position);
//                ItemCollectionClassesMainRightBinding itemBind = (ItemCollectionClassesMainRightBinding) binding;
//                itemBind.setCollectionName(collection.getNameEntity(getGson()).getNameLocale());
//                itemBind.setCollectionAvatar(collection.getImage());
//                itemBind.setTotalClasses(collection.getTotalClasses());
//            }
//        }

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

    @NonNull
    @Override
    public ItemCollectionClassMainVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemCollectionClassesMainBinding binding = ItemCollectionClassesMainBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        int width = viewGroup.getMeasuredWidth() / 2;
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(width, (int) (width * (i == TYPE_LEFT ? 1.5 : 1.7))));
        return new ItemCollectionClassMainVH(binding,gson, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCollectionClassMainVH itemCollectionClassMainVH, int i) {
        itemCollectionClassMainVH.bind(collections.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        return position != 1 ? TYPE_LEFT : TYPE_RIGHT;
    }

    public interface ItemCollectionsClassesMainClickListener {
        void onItemCollectionClassesClick(Collection collection);
    }

}

