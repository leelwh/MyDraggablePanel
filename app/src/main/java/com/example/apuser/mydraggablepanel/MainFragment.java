package com.example.apuser.mydraggablepanel;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.example.apuser.mydraggablepanel.domain.model.MyItemList;
import com.example.apuser.mydraggablepanel.util.ToastUtils;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by apuser on 3/30/15.
 */
public class MainFragment extends BaseFragment implements MainPresenter.View, View.OnClickListener{
    @Inject MainPresenter mainPresenter;
    @InjectView(R.id.recycler_view) RecyclerView recyclerView;
    @InjectView(R.id.pb_loading) ProgressBar pb_loading;
    @InjectView(R.id.v_empty_case) View v_empty_case;

    private MyItemList myItemList = new MyItemList();
    private MyRecyclerAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private Listener listener;
    private final static String TAG = "MainFragment";

    @Override
    public void onClick(View v) {
        int itemPosition = recyclerView.getChildPosition(v);
        mainPresenter.onMyItemClicked(itemPosition);
    }

    public interface Listener {
        public void onClick(MyItem myItem);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.main_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mAdapter = new MyRecyclerAdapter(getActivity(), this);
        mLayoutManager = new LinearLayoutManager(getActivity());
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        initializeRecyclerView();
        mainPresenter.setView(this);
        mainPresenter.initialize();
    }

    @Override public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach");
        super.onAttach(activity);
        if (activity instanceof Listener) {
            this.listener = (Listener) activity;
        }
    }

    @Override public void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
        mainPresenter.resume();
    }

    @Override public void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
        mainPresenter.pause();
    }

    private void initializeRecyclerView() {
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void renderMyItems(Collection<MyItem> myItems) {
        myItemList.clear();
        myItemList.addAll(myItems);
        mAdapter.add(myItems);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateTitleWithCountOfTvShows(int counter) {
        String actionBarTitle = getString(R.string.app_name_with_chapter_counter, counter);
        getActivity().setTitle(actionBarTitle);
    }

    @Override
    public void showConnectionErrorMessage() {
        String connectionError = getString(R.string.connection_error_message);
        ToastUtils.showShortMessage(connectionError, getActivity());
    }

    @Override
    public void showEmptyCase() {
        v_empty_case.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDefaultTitle() {
        getActivity().setTitle(R.string.app_name);
    }

    @Override
    public void showMyItemsTitleAsMessage(MyItem myItem) {
        ToastUtils.showShortMessage(myItem.getTitle(), getActivity());
    }

    @Override
    public void openMyItem(MyItem myItem) {
        listener.onClick(myItem);
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public boolean isAlreadyLoaded() {
        return mAdapter.getItemCount() > 0;
    }
}
