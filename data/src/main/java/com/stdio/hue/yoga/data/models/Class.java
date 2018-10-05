package com.stdio.hue.yoga.data.models;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
public class Class extends BaseObservable implements Serializable {
    private int id;
    private String name;
    private String image;
    private int duration;
    private String description;
    @SerializedName("video_url")
    private String videoUrl;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
