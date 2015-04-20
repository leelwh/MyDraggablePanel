package com.example.apuser.mydraggablepanel;

import android.app.Activity;
import android.content.Context;

import com.example.apuser.mydraggablepanel.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by apuser on 3/30/15.
 */
@Module(
        injects = {
                MainActivity.class,
                MainFragment.class,
                DraggableFragment.class,
        },
        library = true,
        complete = false
)
public final class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityContext @Provides
    Context provideActivityContext() {
        return activity;
    }
}
