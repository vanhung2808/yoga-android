package com.stdio.hue.yoga.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.modules.classes.detail.ui.activities.ClassesDetailActivity;
import com.stdio.hue.yoga.services.models.DownloadInfo;

import java.util.List;

/**
 * Created by TranHuuPhuc on 12/6/18.
 */
public class DownloadService extends Service {
    public static final int DOWNLOAD_ERROR = 101;
    private String YOGA_PREFERENCES = "yoga-download";
    private String YOGA_DOWNLOAD_INFO = "yoga-download-info";
    private Gson gson = new GsonBuilder().create();
    private DownloadBinder binder = new DownloadBinder();

    public class DownloadBinder extends Binder {
        public DownloadService getService() {
            return DownloadService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        pauseDownloadVideo();
        return super.onUnbind(intent);
    }

    private List<DownloadInfo> getListDownloadFromPreferrence() {
        return gson.fromJson(getSharedPreferences(YOGA_PREFERENCES, Context.MODE_PRIVATE).getString(YOGA_DOWNLOAD_INFO, ""), new TypeToken<List<DownloadInfo>>() {
        }.getType());
    }

    private void saveStatusPreferrence(List<DownloadInfo> downloadInfoList) {
        this.getSharedPreferences(YOGA_PREFERENCES, Context.MODE_PRIVATE).edit().putString(YOGA_DOWNLOAD_INFO, gson.toJson(downloadInfoList)).apply();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        onUnbind(rootIntent);
        onDestroy();
        super.onTaskRemoved(rootIntent);
    }

    public void startDownloadVideo(Classes classes) {
        DownloadInfo downloadInfo = new DownloadInfo(
                "classes" + classes.getId(),
                PRDownloader.download(classes.getVideoUrl(), getFilesDir().getPath(), "classes" + classes.getId() + ".mp4").build()
                        .setOnStartOrResumeListener(() -> {
                        })
                        .setOnPauseListener(() -> {
                        })
                        .setOnCancelListener(() -> {
                        })
                        .setOnProgressListener(progress -> sendBroadCast((int) ((progress.currentBytes * 100) / progress.totalBytes)))
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                List<DownloadInfo> downloadInfoList = getListDownloadFromPreferrence();
                                if (downloadInfoList != null) {
                                    for (DownloadInfo downloadInfo : downloadInfoList) {
                                        if (downloadInfo.getVideoName().equals("classes" + classes.getId())) {
                                            downloadInfoList.remove(downloadInfo);
                                            break;
                                        }
                                    }
                                    saveStatusPreferrence(downloadInfoList);
                                }
                            }

                            @Override
                            public void onError(Error error) {
                                Toast.makeText(getBaseContext(), "Can't download this video", Toast.LENGTH_SHORT).show();
                                sendBroadCast(DOWNLOAD_ERROR);
                            }
                        }),
                -1);
        List<DownloadInfo> downloadInfoList = getListDownloadFromPreferrence();
        if (downloadInfoList != null) {
            downloadInfoList.add(downloadInfo);
            saveStatusPreferrence(downloadInfoList);
        }
    }

    public void pauseDownloadVideo() {
        List<DownloadInfo> downloadInfoList = getListDownloadFromPreferrence();
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                PRDownloader.pause(downloadInfo.getIdDownload());
            }
        }
    }

    public void pauseDownloadVideo(String videoName) {
        List<DownloadInfo> downloadInfoList = getListDownloadFromPreferrence();
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo.getVideoName().equals(videoName)) {
                    PRDownloader.pause(downloadInfo.getIdDownload());
                    break;
                }
            }
        }
    }

    public void sendBroadCast(int progressPercentage) {
        Intent intent = new Intent(ClassesDetailActivity.PROGRESS);
        intent.putExtra(ClassesDetailActivity.PROGRESS_PERCENTAGE, progressPercentage);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
