package com.example.apuser.mydraggablepanel;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by apuser on 3/30/15.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    protected abstract int getFragmentLayout();
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    private void injectViews(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    private void injectDependencies() {
        ((BaseActivity) getActivity()).inject(this);
    }
}
