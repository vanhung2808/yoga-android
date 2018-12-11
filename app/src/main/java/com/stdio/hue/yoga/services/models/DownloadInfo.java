package com.stdio.hue.yoga.services.models;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by TranHuuPhuc on 12/6/18.
 */
public class DownloadInfo extends BaseObservable implements Serializable {
    private String videoName;
    private int idDownload;
    private int progress;

    public DownloadInfo() {

    }

    public DownloadInfo(String videoName, int idDownload, int progress) {
        this.videoName = videoName;
        this.idDownload = idDownload;
        this.progress = progress;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getIdDownload() {
        return idDownload;
    }

    public void setIdDownload(int idDownload) {
        this.idDownload = idDownload;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
