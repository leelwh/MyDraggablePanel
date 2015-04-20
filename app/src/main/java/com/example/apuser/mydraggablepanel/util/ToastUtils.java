package com.example.apuser.mydraggablepanel.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by apuser on 3/30/15.
 */
public class ToastUtils {

    private ToastUtils() {
        //Empty
    }

    public static void showError(final String message, final Context context) {
        getToast(message, context).show();
    }

    public static void showShortMessage(String message, Context context) {
        getToast(message, context, Toast.LENGTH_SHORT).show();
    }

    private static Toast getToast(String message, Context context) {
        return getToast(message, context, Toast.LENGTH_LONG);
    }

    private static Toast getToast(String message, Context context, int length) {
        return Toast.makeText(context, message, length);
    }
}
