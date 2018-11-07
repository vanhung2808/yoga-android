package com.stdio.hue.yoga.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

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
    private int duration;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "video_url")
    private String videoUrl;
    @ColumnInfo(name = "collection_id")
    private int collectionId;
    @ColumnInfo(name = "duration_id")
    private int durationId;
    @ColumnInfo(name = "focus_id")
    private int focusId;
    @ColumnInfo(name = "ability_id")
    private int abilityId;
    @ColumnInfo(name = "intensity_id")
    private int intensityId;
    @ColumnInfo(name = "poster_video")
    private String posterVideo;
    @ColumnInfo(name = "created_at")
    private long createdAt;
    @ColumnInfo(name = "updated_at")
    private long updatedAt;


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

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getDurationId() {
        return durationId;
    }

    public void setDurationId(int durationId) {
        this.durationId = durationId;
    }

    public int getFocusId() {
        return focusId;
    }

    public void setFocusId(int focusId) {
        this.focusId = focusId;
    }

    public int getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
    }

    public int getIntensityId() {
        return intensityId;
    }

    public void setIntensityId(int intensityId) {
        this.intensityId = intensityId;
    }

    public String getPosterVideo() {
        return posterVideo;
    }

    public void setPosterVideo(String posterVideo) {
        this.posterVideo = posterVideo;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
