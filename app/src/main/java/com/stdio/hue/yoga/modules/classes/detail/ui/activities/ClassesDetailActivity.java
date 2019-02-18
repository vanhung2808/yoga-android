package com.stdio.hue.yoga.modules.classes.detail.ui.activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.github.abdularis.buttonprogress.DownloadButtonProgress;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.data.models.Classes;
import com.stdio.hue.yoga.data.models.Poses;
import com.stdio.hue.yoga.databinding.ActivityClassesDetailBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.classes.detail.presenters.ClassesDetailPresenter;
import com.stdio.hue.yoga.modules.classes.detail.ui.adapters.ClassesDetailAdapter;
import com.stdio.hue.yoga.modules.poses.detail.ui.activities.PosesDetailActivity;
import com.stdio.hue.yoga.modules.upgrade.ui.activities.UpgradeActivity;
import com.stdio.hue.yoga.modules.video.ui.activity.VideoActivity;
import com.stdio.hue.yoga.services.DownloadService;
import com.stdio.hue.yoga.shares.utils.ConvertJsonToNameEntity;
import com.stdio.hue.yoga.shares.utils.SHStringHelper;
import com.stdio.hue.yoga.shares.widget.RxDialog;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

import static com.stdio.hue.yoga.services.DownloadService.DOWNLOAD_ERROR;
import static com.stdio.hue.yoga.shares.utils.Constant.EXTRA_CLASSES;

/**
 * Created by TranHuuPhuc on 12/4/18.
 */
public class ClassesDetailActivity extends BaseYogaActivity<ClassesDetailPresenter, ActivityClassesDetailBinding> implements ClassesDetailAdapter.ClassesDetailAdapterListener {
    public static final String PROGRESS = "progress";
    public static final String PROGRESS_PERCENTAGE = "progress-percentage";

    public static void start(Context context, Classes classes) {
        Intent starter = new Intent(context, ClassesDetailActivity.class);
        starter.putExtra(EXTRA_CLASSES, classes);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_classes_detail;
    }

    private boolean isIdle = false;
    private Classes classes;
    private DownloadService mBindService;
    private ServiceConnection serviceConnection;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int progress = intent.getIntExtra(PROGRESS_PERCENTAGE, -1);
                if (progress == DOWNLOAD_ERROR) {
                    isIdle = true;
                    viewDataBinding.btDownload.setIdle();
                }
                if (progress == 100) {
                    viewDataBinding.ivPlayVideo.setVisibility(View.VISIBLE);
                    viewDataBinding.btDownload.setVisibility(View.GONE);
                } else {
                    if (!isIdle) {
                        viewDataBinding.btDownload.setDeterminate();
                        viewDataBinding.btDownload.setProgress(progress);
                    }
                }
            }
        }
    };
    private BillingProcessor billingProcessor;

    @Override
    protected void init() {
        initToolbar();
        billingProcessor = new BillingProcessor(this, null, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {

            }

            @Override
            public void onPurchaseHistoryRestored() {

            }

            @Override
            public void onBillingError(int errorCode, @Nullable Throwable error) {

            }

            @Override
            public void onBillingInitialized() {

            }
        });
        billingProcessor.initialize();
        initButtonDownload();
        if (getIntent() != null) {
            classes = (Classes) getIntent().getSerializableExtra(EXTRA_CLASSES);
            if (getExitsVideo("classes" + classes.getId() + ".mp4") == null) {
                viewDataBinding.ivPlayVideo.setVisibility(View.GONE);
                viewDataBinding.btDownload.setVisibility(View.VISIBLE);
            } else {
                viewDataBinding.ivPlayVideo.setVisibility(View.VISIBLE);
                viewDataBinding.btDownload.setVisibility(View.GONE);
            }
            viewDataBinding.setClassesName(classes.getNameEntity(gson).getNameLocale());
            viewDataBinding.setClassesImage(classes.getImage());
            disposableManager.add(getPresenter().getData(classes.getId(), classes.getAbilityId(), classes.getIntensityId(), classes.getFocusId())
                    .doOnSubscribe(d -> loading(true))
                    .doOnError(throwable -> loading(false))
                    .doOnComplete(() -> loading(false))
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(results -> {
                        viewDataBinding.setAbilityName(ConvertJsonToNameEntity.getNameEntity(gson, (String) results.get(0)).getNameLocale());
                        viewDataBinding.setIntensityName(ConvertJsonToNameEntity.getNameEntity(gson, (String) results.get(1)).getNameLocale());
                        viewDataBinding.setFocusName(ConvertJsonToNameEntity.getNameEntity(gson, (String) results.get(2)).getNameLocale());
                        List<Poses> poses = (List<Poses>) results.get(3);
                        viewDataBinding.setTotalPosesAndTime(poses.size() + " Poses - " + ConvertJsonToNameEntity.getNameEntity(gson, classes.getDuration()).getNameLocale());
                        viewDataBinding.rvPoses.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
                        viewDataBinding.rvPoses.setAdapter(new ClassesDetailAdapter(poses, this));
                    }));
        }
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mBindService = ((DownloadService.DownloadBinder) iBinder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        bindService(new Intent(this, DownloadService.class), serviceConnection, Context.BIND_AUTO_CREATE);
        initEvent();

    }

    private void initButtonDownload() {
        viewDataBinding.btDownload.setIdleIcon(ContextCompat.getDrawable(this, R.drawable.ic_download_white));
        viewDataBinding.btDownload.setIdleIconHeight(40);
        viewDataBinding.btDownload.setIdleIconWidth(40);
        viewDataBinding.btDownload.setIdleBgColor(ContextCompat.getColor(this, android.R.color.transparent));
        viewDataBinding.btDownload.setDeterminateBgColor(ContextCompat.getColor(this, android.R.color.transparent));
        viewDataBinding.btDownload.setProgressDeterminateColor(ContextCompat.getColor(this, R.color.colorOrange));
        viewDataBinding.btDownload.setCancelIconHeight(30);
        viewDataBinding.btDownload.setCancelIconWidth(30);
        viewDataBinding.btDownload.setCancelIcon(ContextCompat.getDrawable(this, R.drawable.ic_stop_download));
    }

    private void initEvent() {
        viewDataBinding.btDownload.addOnClickListener(new DownloadButtonProgress.OnClickListener() {
            @Override
            public void onIdleButtonClick(View view) {
                //Todo show icon download
                if (!billingProcessor.isPurchased("android.test.purchased")) {
                    UpgradeActivity.start(ClassesDetailActivity.this);
                } else {
                    if (!SHStringHelper.nullOrEmpty(classes.getVideoUrl())) {
                        mBindService.startDownloadVideo(classes);
                        viewDataBinding.btDownload.setDeterminate();
                        viewDataBinding.btDownload.setMaxProgress(100);
                        isIdle = false;
                    }
                }
            }

            @Override
            public void onCancelButtonClick(View view) {
                //Todo pause
                mBindService.pauseDownloadVideo("classes" + classes.getId());
                viewDataBinding.btDownload.setIdle();
                isIdle = true;
            }

            @Override
            public void onFinishButtonClick(View view) {
                //Todo finish download
            }
        });

        viewDataBinding.ivPlayVideo.setOnClickListener(view -> {
            if (!billingProcessor.isPurchased("android.test.purchased")) {
                UpgradeActivity.start(ClassesDetailActivity.this);
            } else {
                VideoActivity.start(this, "classes" + classes.getId() + ".mp4");
            }
        });
        viewDataBinding.ivCopy.setOnClickListener(view -> disposableManager.add(RxDialog.confirmDialog(this, getString(R.string.app_name), "A copy will be created in Custom Classes", "Copy Class", "Cancel")
                .map(v -> v)
                .subscribe(v -> {
                    if (v) {

                    }
                })));
        viewDataBinding.ivEdit.setOnClickListener(view -> disposableManager.add(RxDialog.confirmDialog(this, getString(R.string.app_name), "Studio classes cannot be edited. Would you like to create an editable copy in Custom Classes?", "Copy Class", "Cancel")
                .map(v -> v)
                .subscribe(v -> {
                    if (v) {

                    }
                })));
    }

    private void initToolbar() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.toolbar.setTitle(R.string.classes);
        viewDataBinding.collapsToolbar.setTitleEnabled(false);
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.classes);
    }

    @Override
    protected void startScreen() {

    }

    @Override
    protected void resumeScreen() {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(PROGRESS));

    }

    @Override
    protected void pauseScreen() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void destroyScreen() {

    }

    @NonNull
    @Override
    protected ClassesDetailPresenter createPresenter() {
        return getAppComponent().getClassesDetailComponent().getClassesDetailPresenter();
    }

    @Override
    public void onPosesClick(Poses poses) {
        PosesDetailActivity.start(this, poses);
    }
}
