package com.stdio.hue.yoga.modules.main.ui.fragments.schedule;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.view.View;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.stdio.hue.yoga.R;
import com.stdio.hue.yoga.base.core.mvp.BasePresenter;
import com.stdio.hue.yoga.databinding.FragmentMainScheduleBinding;
import com.stdio.hue.yoga.modules.base.BaseYogaFragment;
import com.stdio.hue.yoga.modules.settings.ui.activities.SettingActivity;
import com.stdio.hue.yoga.shares.utils.AppBarStateChangeListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by TranHuuPhuc on 9/19/18.
 */
public class ScheduleMainFragment extends BaseYogaFragment<BasePresenter, FragmentMainScheduleBinding> {

    public static ScheduleMainFragment newInstance() {
        Bundle args = new Bundle();
        ScheduleMainFragment fragment = new ScheduleMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_schedule;
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

    @Override
    protected void init(@Nullable View view) {
        initAppBar();
        initCalendar();
        viewDataBinding.datePickerTextView.setText(dateFormat.format(new Date()));
        setCurrentDate(new Date());
        initEvent();
    }

    private void initEvent() {
        viewDataBinding.ivAdd.setOnClickListener(view -> {

        });
        viewDataBinding.ivBackCalendar.setOnClickListener(view -> {
            viewDataBinding.compactcalendarView.scrollLeft();
        });
        viewDataBinding.ivNextCalendar.setOnClickListener(view -> {
            viewDataBinding.compactcalendarView.scrollRight();
        });
        viewDataBinding.ivSetting.setOnClickListener(view -> {
            SettingActivity.start(getContext());
        });
        viewDataBinding.ivLogBook.setOnClickListener(view -> {

        });
    }

    private void initCalendar() {
        viewDataBinding.compactcalendarView.setDayColumnNames(new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});
        viewDataBinding.compactcalendarView.setFirstDayOfWeek(Calendar.SUNDAY);
        viewDataBinding.compactcalendarView.setLocale(TimeZone.getDefault(), Locale.ENGLISH);
        viewDataBinding.compactcalendarView.setUseThreeLetterAbbreviation(true);
        viewDataBinding.compactcalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                setTitle(dateFormat.format(dateClicked));
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                setTitle(dateFormat.format(firstDayOfNewMonth));
            }
        });
    }

    private void initAppBar() {
        viewDataBinding.appbarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.COLLAPSED) {
                    viewDataBinding.ivAdd.setVisibility(View.GONE);
                } else {
                    viewDataBinding.ivAdd.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setTitle(String title) {
        if (viewDataBinding.datePickerTextView != null) {
            viewDataBinding.datePickerTextView.setText(title);
        }
    }

    private void setCurrentDate(Date date) {
        if (viewDataBinding.compactcalendarView != null) {
            viewDataBinding.compactcalendarView.setCurrentDate(date);
        }
    }

    @Override
    protected void screenResume() {

    }

    @Override
    protected void screenPause() {

    }

    @Override
    protected void screenStart(@Nullable Bundle saveInstanceState) {

    }

    @Override
    protected void attach(Context context) {

    }

    @NonNull
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter();
    }

}
