package com.stdio.hue.yoga.modules.main.ui.adapters.homenews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.ItemNewsMainBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homenews.viewholder.ItemNewMainVH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DucPham on 25/11/2018.
 */
public class NewsMainAdapter extends RecyclerView.Adapter<ItemNewMainVH> {
    private static final int TYPE_LEFT = 110;
    private static final int TYPE_RIGHT = 111;
    private Gson gson;
    private List<News> items;
    private ItemNewsMainClickListener listener;

    public NewsMainAdapter(ItemNewsMainClickListener listener) {
        items = new ArrayList<>();
        this.gson = new GsonBuilder().create();
        this.listener = listener;
    }


//    @Override
//    public void updateBinding(ViewDataBinding binding, int position) {
//        if (binding instanceof ItemNewsMainBinding) {
//            News news = items.get(position);
//            ItemNewsMainBinding itemBind = (ItemNewsMainBinding) binding;
//            if (news != null) {
//                itemBind.setTitleNews(news.getNameEntity(getGson()).getNameLocale());
//                itemBind.setImageNews(news.getImage());
//                itemBind.setTotalFavorite(String.valueOf(news.getTotalFavorite()));
//            }
//            itemBind.cbFavorite.setOnClickListener(v -> {
//                listener.onClickFavorite(position);
//            });
//        }
//    }

    public News getNews(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    @NonNull
    @Override
    public ItemNewMainVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemNewsMainBinding binding = ItemNewsMainBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        int width = viewGroup.getMeasuredWidth() / 2;
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(width, (int) (width * (i == TYPE_LEFT ? 1.9 : 2.2))));
        return new ItemNewMainVH(listener, binding, gson);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewMainVH itemNewMainVH, int i) {
        itemNewMainVH.bind(items.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        return position != 1 ? TYPE_LEFT : TYPE_RIGHT;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateData(List<News> news) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        int size = news.size();
        this.items.clear();
        this.items.addAll(news);
//        notifyDataSetChanged();
        notifyItemRangeChanged(size, news.size());
    }

    public interface ItemFavoriteClickListener {
        void onItemFavoriteClickListener(View view);
    }

    public interface ItemNewsMainClickListener {
        void onItemNewsMainClickListener(News news);
    }
}