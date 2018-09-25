package com.stdio.hue.yoga.common.widgets.util;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.stdio.hue.yoga.common.R;

/**
 * Created by TranHuuPhuc on 8/6/18.
 */
public class MessageUtils {

    public static void showErrorMessage(Activity activity,
                                        CharSequence message) {
        if (message != null) {
            Snackbar snackbar = Snackbar
                    .make(activity.findViewById(android.R.id.content),
                            message,
                            Snackbar.LENGTH_LONG);
            View view = snackbar.getView();
            view.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorRed));
            snackbar.show();
        }
    }

    public static void showErrorMessage(Activity activity,
                                        @StringRes int message) {
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorRed));
        snackbar.show();
    }

    public static void showInformationMessage(Activity activity,
                                              @StringRes int message) {
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorGreenLight));
        snackbar.show();
    }

    public static void showInformationMessage(Activity activity,
                                              @NonNull CharSequence message) {
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorGreenLight));
        snackbar.show();
    }

    public static void showWarningMessage(Activity activity, @StringRes int message) {
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(Color.YELLOW);
        snackbar.show();
    }

    public static void showWarningMessage(Activity activity, @NonNull CharSequence message) {
        Snackbar snackbar = Snackbar
                .make(activity.findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(Color.YELLOW);
        snackbar.show();
    }
}
