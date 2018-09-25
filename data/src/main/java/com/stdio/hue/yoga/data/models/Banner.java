package com.stdio.hue.yoga.data.models;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class Banner extends BaseObservable implements Serializable {
    private int id;
    private int type;
    private Collection collection;
    private String image;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
