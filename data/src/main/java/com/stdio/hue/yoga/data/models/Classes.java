package com.stdio.hue.yoga.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 9/25/18.
 */
@Entity(tableName = "classes")
public class Classes extends BaseObservable implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "duration")
    private String duration;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "video_url")
    private String videoUrl;
    @ColumnInfo(name = "collection_id")
    private String collectionId;
    @ColumnInfo(name = "duration_id")
    private String durationId;
    @ColumnInfo(name = "focus_id")
    private String focusId;
    @ColumnInfo(name = "ability_id")
    private String abilityId;
    @ColumnInfo(name = "intensity_id")
    private String intensityId;
    @ColumnInfo(name = "poster_video")
    private String posterVideo;
    @ColumnInfo(name = "created_at")
    private String createdAt;
    @ColumnInfo(name = "updated_at")
    private String updatedAt;
    @ColumnInfo(name = "status_download")
    private int statusDownload;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getDurationId() {
        return durationId;
    }

    public void setDurationId(String durationId) {
        this.durationId = durationId;
    }

    public String getFocusId() {
        return focusId;
    }

    public void setFocusId(String focusId) {
        this.focusId = focusId;
    }

    public String getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(String abilityId) {
        this.abilityId = abilityId;
    }

    public String getIntensityId() {
        return intensityId;
    }

    public void setIntensityId(String intensityId) {
        this.intensityId = intensityId;
    }

    public String getPosterVideo() {
        return posterVideo;
    }

    public void setPosterVideo(String posterVideo) {
        this.posterVideo = posterVideo;
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

    public int getStatusDownload() {
        return statusDownload;
    }

    public void setStatusDownload(int statusDownload) {
        this.statusDownload = statusDownload;
    }

    public NameEntity getNameEntity(Gson gson) {
        return gson.fromJson(name, NameEntity.class);
    }

}
