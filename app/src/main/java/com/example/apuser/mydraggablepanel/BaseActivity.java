package com.example.apuser.mydraggablepanel;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by apuser on 3/30/15.
 */
public abstract class BaseActivity extends Activity {
    private ObjectGraph activityScopeGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    public void inject(Object object) {
        activityScopeGraph.inject(object);
    }

    private void injectDependencies() {
        MyApplication myApplication = (MyApplication) getApplication();
        List<Object> activityScopeModules = getModules();
        activityScopeModules.add(new ActivityModule(this));
        activityScopeGraph = myApplication.plus(activityScopeModules);
        inject(this);
    }

    protected abstract List<Object> getModules();

    private void injectViews() {
        ButterKnife.inject(this);
    }
}
