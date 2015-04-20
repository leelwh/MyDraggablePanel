package com.example.apuser.mydraggablepanel.executor;

import android.os.Handler;
import android.os.Looper;


import javax.inject.Inject;

/**
 * Created by apuser on 3/30/15.
 */
public class MainThreadImpl implements MainThread {
    private Handler handler;

    @Inject
    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
