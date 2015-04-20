package com.example.apuser.mydraggablepanel;

import android.content.Context;

import com.example.apuser.mydraggablepanel.domain.MyItemsModule;
import com.example.apuser.mydraggablepanel.executor.ExecutorModule;

import dagger.Module;

/**
 * Created by apuser on 3/30/15.
 */
@Module(
        includes = {
                ExecutorModule.class, MyItemsModule.class,
        },
        injects = {
                MyApplication.class
        },
        library = true
)
public final class RootModule {
    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }
}
