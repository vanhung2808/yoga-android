package com.stdio.hue.yoga.shares.social;


import android.app.Activity;
import android.content.Intent;

import java.util.Map;

public interface SocialNetworkProvider {

    interface SocialCallback {
        void onError(String message, Exception e);

        void onSuccess(Map<String, String> metaData);
    }

    void initialize();

    void authorize(Activity activity, SocialCallback callback);

    boolean onActivityResult(int requestCode, int resultCode, Intent data);
}