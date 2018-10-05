package com.stdio.hue.yoga.data.models;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class Category extends BaseObservable implements Serializable {
    private int id;
    private String name;

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
