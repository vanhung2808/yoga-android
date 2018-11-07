package com.stdio.hue.yoga.modules.main.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.ActivityMainBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaActivity;
import com.stdio.hue.yoga.modules.main.ui.adapters.MainPagerAdapter;
import com.stdio.hue.yoga.shares.utils.Constant;

/**
 * Created by TranHuuPhuc on 9/19/18.
 */
public class MainActivity extends BaseYogaActivity<BasePresenter, ActivityMainBinding> implements ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {
    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        viewDataBinding.vpHome.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        viewDataBinding.navigation.setOnNavigationItemSelectedListener(this);
        viewDataBinding.vpHome.addOnPageChangeListener(this);
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

    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        viewDataBinding.navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_classes:
                viewDataBinding.vpHome.setCurrentItem(Constant.TAB_HOME_CLASSES);
                break;
            case R.id.navigation_poses:
                viewDataBinding.vpHome.setCurrentItem(Constant.TAB_HOME_POSES);
                break;
            case R.id.navigation_news:
                viewDataBinding.vpHome.setCurrentItem(Constant.TAB_HOME_NEWS);
                break;
            case R.id.navigation_schedule:
                viewDataBinding.vpHome.setCurrentItem(Constant.TAB_HOME_SCHEDULE);
                break;
        }
        return false;
    }
}
