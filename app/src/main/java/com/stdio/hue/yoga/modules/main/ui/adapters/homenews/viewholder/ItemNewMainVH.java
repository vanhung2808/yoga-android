package com.stdio.hue.yoga.modules.main.ui.adapters.homenews.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.ItemNewsMainBinding;
import com.stdio.hue.yoga.modules.main.ui.adapters.homenews.NewsMainAdapter;
import com.stdio.hue.yoga.shares.utils.ViewUtils;

/**
 * Created by dungbeo on 1/8/2020.
 */
public class ItemNewMainVH extends RecyclerView.ViewHolder {

    private NewsMainAdapter.ItemNewsMainClickListener listener;
    private ItemNewsMainBinding binding;
    private Gson gson;
    private NewsMainAdapter.ItemFavoriteClickListener favoriteListener;
    int total;

    public ItemNewMainVH(@NonNull NewsMainAdapter.ItemNewsMainClickListener listener, ItemNewsMainBinding binding, Gson gson) {
        super(binding.getRoot());
        this.listener = listener;
        this.binding = binding;
        this.gson = new Gson();
    }

    public void bind(News news) {
        total = news.getTotalFavorite();
        binding.setTotalFavorite(String.valueOf(total));
        binding.setTitleNews(news.getNameEntity(gson).getNameLocale());
        binding.setImageNews(news.getImage());
        ViewUtils.setOnDelayClick(binding.getRoot(), v -> listener.onItemNewsMainClickListener(news));
    }
}
