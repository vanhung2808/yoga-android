package com.stdio.hue.yoga.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by DucPham on 28/11/2018.
 */
@Entity(tableName = "news")
public class News extends BaseObservable implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "total_favorite")
    private int totalFavorite;
    @ColumnInfo(name = "created_at")
    private String createdAt;
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotalFavorite() {
        return totalFavorite;
    }

    public void setTotalFavorite(int totalFavorite) {
        this.totalFavorite = totalFavorite;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public NameEntity getNameEntity(Gson gson) {
        return gson.fromJson(title, NameEntity.class);
    }

    public NameEntity getContentLocale(Gson gson) {
        return gson.fromJson(content, NameEntity.class);
    }
}
