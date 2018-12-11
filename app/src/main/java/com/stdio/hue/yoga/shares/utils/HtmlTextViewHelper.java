package com.stdio.hue.yoga.shares.utils;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by TranHuuPhuc on 12/11/18.
 */
public class HtmlTextViewHelper {
    public static void showHtmlTextView(String content, TextView tvHtml) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvHtml.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            tvHtml.setText(Html.fromHtml(content));
        }
    }
}
