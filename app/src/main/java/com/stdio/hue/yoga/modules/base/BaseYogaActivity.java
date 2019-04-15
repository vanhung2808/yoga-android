package com.stdio.hue.yoga.modules.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.stdio.hue.yoga.ProjectApplication;
import com.stdio.hue.yoga.base.core.BaseViperActivity;
import com.stdio.hue.yoga.base.core.mvp.Presenter;
import com.stdio.hue.yoga.di.components.AppComponent;
import com.stdio.hue.yoga.shares.widget.LoadingDialog;

import java.io.File;
import java.util.List;

/**
 * Created by TranHuuPhuc on 7/6/18.
 */
public abstract class BaseYogaActivity<P extends Presenter, V extends ViewDataBinding> extends BaseViperActivity<P> {
    protected V viewDataBinding;

    protected LoadingDialog loadingDialog;
    protected Gson gson;

    protected void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.show();
    }

    protected void hideLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    protected void loading(boolean show) {
        if (show) {
            showLoadingDialog();
        } else {
            hideLoadingDialog();
        }
    }

    /**
     * setup content layout
     *
     * @return layout id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * init for data
     */
    protected abstract void init();

    /**
     * start screen
     */
    protected abstract void startScreen();

    /**
     * resume screen
     */
    protected abstract void resumeScreen();

    /**
     * pause screen
     */
    protected abstract void pauseScreen();

    /**
     * destroy screen
     */
    protected abstract void destroyScreen();

    protected AppComponent getAppComponent() {
        return ((ProjectApplication) getApplication()).getAppComponent();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        gson = new GsonBuilder().create();
        init();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        startScreen();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startScreen();
    }

    @Override
    public void onResume() {
        super.onResume();
        resumeScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyScreen();
    }

    public Uri getExitsVideo(String videoName) {
        File file = new File(getFilesDir(), videoName);
        if (file.exists()) {
            return Uri.parse(file.getPath());
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                // check if all permissions are granted
                if (report.areAllPermissionsGranted()) {

                }
                // check for permanent denial of any permission
                if (report.isAnyPermissionPermanentlyDenied()) {
                    // show alert dialog navigating to Settings
                    showSettingsDialog();
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }

        }).withErrorListener(error -> Toast.makeText(BaseYogaActivity.this, "Error occurred! ", Toast.LENGTH_SHORT).show()).check();
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    public void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

}
