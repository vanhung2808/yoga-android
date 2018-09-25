package com.stdio.hue.yoga.data.models;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class Collection extends BaseObservable implements Serializable {
    private int id;
    private String name;
    private String image;
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
