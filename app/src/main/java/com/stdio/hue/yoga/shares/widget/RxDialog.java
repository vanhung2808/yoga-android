package com.stdio.hue.yoga.shares.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by TranHuuPhuc on 12/10/18.
 */
public class RxDialog {

    public static Observable<Boolean> confirmDialog(Context context, String title, String message, String positiveText, String negativeText) {
        return Observable.create(new ConfirmDialogObservable(context, title, message, positiveText, negativeText));
    }

    public static Observable<Boolean> successDialog(Context context, String title, String message) {
        return Observable.create(new SuccessDialogObservable(context, title, message));
    }

    static class ConfirmDialogObservable implements ObservableOnSubscribe<Boolean> {
        private Context context;
        private final String title;
        private final String message;
        private String positiveText;
        private String negativeText;
        private Dialog dialog;

        ConfirmDialogObservable(Context context, String title, String message, String positiveText, String negativeText) {
            this.context = context;
            this.title = title;
            this.message = message;
            this.positiveText = positiveText;
            this.negativeText = negativeText;
        }

        @Override
        public void subscribe(ObservableEmitter<Boolean> emitter) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog = new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(positiveText, ((dialog, which) -> {
                        dialog.dismiss();
                        emitter.onNext(true);
                    }))
                    .setNegativeButton(negativeText, ((dialog, which) -> {
                        dialog.dismiss();
                        emitter.onNext(false);
                    }))
                    .create();
            dialog.show();
        }
    }

    static class SuccessDialogObservable implements ObservableOnSubscribe<Boolean> {
        private Context context;
        private final String title;
        private final String message;
        private Dialog dialog;

        SuccessDialogObservable(Context context, String title, String message) {
            this.context = context;
            this.title = title;
            this.message = message;
        }

        @Override
        public void subscribe(ObservableEmitter<Boolean> emitter) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
            dialog = new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("OK", ((dialog, which) -> {
                        dialog.dismiss();
                        emitter.onNext(true);
                    }))
                    .create();
            dialog.show();
        }
    }
}
