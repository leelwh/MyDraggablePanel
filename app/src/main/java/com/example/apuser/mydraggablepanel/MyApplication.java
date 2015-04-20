package com.example.apuser.mydraggablepanel;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by apuser on 3/30/15.
 */
public class MyApplication extends Application {
    private ObjectGraph objectGraph;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependenciesInjector();
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public ObjectGraph plus(List<Object> modules) {
        return objectGraph.plus(modules.toArray());
    }

    private void initializeDependenciesInjector() {
        objectGraph = ObjectGraph.create(new RootModule(this));
        objectGraph.inject(this);
    }
}
