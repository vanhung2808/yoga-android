package com.stdio.hue.yoga.modules.newsdetail.ui.adapter;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by DucPham on 21/10/2018.
 */

public class WebViewClientAdapter extends WebViewClient {

    private String url;

    public WebViewClientAdapter(String url) {
        this.url= url;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i("LogWebView","Click on any interlink on webview that time you got url :-" + url);
        //return super.shouldOverrideUrlLoading(view, url);
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.i("LogWebView", "Your current url when webpage loading.." + url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Log.i("LogWebView", "Your current url when webpage loading.. finish" + url);
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

}
