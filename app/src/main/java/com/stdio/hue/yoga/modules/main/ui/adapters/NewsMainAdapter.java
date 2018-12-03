package com.stdio.hue.yoga.modules.main.ui.adapters;

import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.AbsBindingAdapter;
import com.stdio.hue.yoga.data.models.News;
import com.stdio.hue.yoga.databinding.ItemNewsMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DucPham on 25/11/2018.
 */
public class NewsMainAdapter extends AbsBindingAdapter<ItemNewsMainBinding>{

    private List<News> items;
    private NewsMainAdapterListener listener;

    public NewsMainAdapter(RecyclerViewClickListener itemListener, NewsMainAdapterListener listener) {
        super(itemListener);
        this.listener = listener;
    }

    @Override
    protected int getLayoutResourceId(int viewType) {
        return R.layout.item_news_main;
    }

    @Override
    public void updateBinding(ViewDataBinding binding, int position) {
        if (binding instanceof ItemNewsMainBinding) {
            News news = items.get(position);
            ItemNewsMainBinding itemBind = (ItemNewsMainBinding) binding;
            if(news != null){
                itemBind.setTitleNews(news.getNameEntity(getGson()).getNameLocale());
                itemBind.setImageNews(news.getImage());
                itemBind.setTotalFavorite(String.valueOf(news.getTotalFavorite()));
            }
            itemBind.cbFavorite.setOnClickListener(v -> {
                listener.onClickFavorite(position);
            });
        }
    }

    public News getNews(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateData(List<News> news) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.clear();
        this.items.addAll(news);
        notifyDataSetChanged();
    }

    public interface NewsMainAdapterListener{
        void onClickFavorite(int position);
    }
}