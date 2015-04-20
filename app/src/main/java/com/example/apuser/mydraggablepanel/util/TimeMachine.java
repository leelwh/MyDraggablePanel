package com.example.apuser.mydraggablepanel.util;

import android.os.Handler;

/**
 * Created by apuser on 3/30/15.
 */
public class TimeMachine {

    private static Handler handler = new Handler();

    private TimeMachine() {
        //Empty
    }

    /**
     * Execute a Runnable implementation some milliseconds in the future.
     *
     * @param runnable to execute.
     * @param delay in miliseconds.
     */
    public static void sendMessageToTheFuture(final Runnable runnable, final int delay) {
        handler.postDelayed(runnable, delay);
    }

    /**
     * Cancel a message already sent to the future.
     */
    public static void cancelMessage(Runnable runnable) {
        handler.removeCallbacks(runnable);
    }
}
