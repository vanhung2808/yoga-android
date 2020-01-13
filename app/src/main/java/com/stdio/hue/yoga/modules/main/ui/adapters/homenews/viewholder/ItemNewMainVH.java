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
        this.gson = gson;
    }

    public void bind(News news) {
        total = news.getTotalFavorite();
        binding.setTotalFavorite(String.valueOf(total));
        binding.setTitleNews(news.getNameEntity(new Gson()).getNameLocale());
        binding.setImageNews(news.getImage());
//            binding.cbFavorite.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                if (binding.cbFavorite.isChecked()) {
//                    total = total + 1;
//                    news.setTotalFavorite(total);
//                    binding.setTotalFavorite(String.valueOf(total));
//                    Log.d("TAG_CHECKBOX", total + "check box true + 1");
//                } else {
//                    total = total - 1;
//                    news.setTotalFavorite(total);
//                    binding.setTotalFavorite(String.valueOf(total));
//                    Log.d("TAG_CHECKBOX", total + "check box false -1");
//                }
//            });
//            Log.d("TAG_CHECKBOX", total + "?total");
        ViewUtils.setOnDelayClick(binding.getRoot(), v -> listener.onItemNewsMainClickListener(news));
    }
}
