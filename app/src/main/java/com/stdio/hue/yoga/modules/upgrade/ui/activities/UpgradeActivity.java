package com.stdio.hue.yoga.modules.upgrade.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.ActivityUpgradeBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;

/**
 * Created by TranHuuPhuc on 11/29/18.
 */
public class UpgradeActivity extends BaseYogaActivity<BasePresenter, ActivityUpgradeBinding> implements BillingProcessor.IBillingHandler {
    public static void start(Context context) {
        Intent starter = new Intent(context, UpgradeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upgrade;
    }

    private BillingProcessor billingProcessor;

    @Override
    protected void init() {
        viewDataBinding.toolbar.setNavigationIcon(R.drawable.ic_back_white);
        viewDataBinding.toolbar.setTitle("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        billingProcessor = new BillingProcessor(this, null, this);
        billingProcessor.initialize();
        viewDataBinding.ivBuyOneYears.setOnClickListener(view -> {
            if (!billingProcessor.isPurchased("android.test.purchased")) {
                billingProcessor.purchase(UpgradeActivity.this, "android.test.purchased");
            } else {
                showToast("Purchased Successful!");
            }
        });
        viewDataBinding.ivBuySevenDays.setOnClickListener(view -> {
            if (!billingProcessor.isPurchased("android.test.purchased")) {
                billingProcessor.purchase(UpgradeActivity.this, "android.test.purchased");
            } else {
                showToast("Purchased Successful!");
            }
        });
    }

    @Override
    protected void startScreen() {

    }

    @Override
    protected void resumeScreen() {

    }

    @Override
    protected void pauseScreen() {

    }

    @Override
    protected void destroyScreen() {
        if (billingProcessor != null) {
            billingProcessor.release();
        }
    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        showToast("onBillingError: " + errorCode);
    }

    @Override
    public void onBillingInitialized() {
//        showToast("onBillingInitialized");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!billingProcessor.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
