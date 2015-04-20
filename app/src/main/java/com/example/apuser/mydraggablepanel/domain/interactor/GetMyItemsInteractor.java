package com.example.apuser.mydraggablepanel.domain.interactor;

import android.util.Log;

import com.example.apuser.mydraggablepanel.domain.GetMyItemsException;
import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.example.apuser.mydraggablepanel.domain.repository.MyRepository;
import com.example.apuser.mydraggablepanel.executor.Executor;
import com.example.apuser.mydraggablepanel.executor.Interactor;
import com.example.apuser.mydraggablepanel.executor.MainThread;
import com.example.apuser.mydraggablepanel.util.RandomUtils;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by apuser on 3/30/15.
 */
public class GetMyItemsInteractor implements GetMyItems, Interactor {
    private static final int PERCENTAGE_OF_FAILS = 50;
    private static final long WAIT_TIME = 1500;

    private final Executor executor;
    private final MainThread mainThread;
    private final MyRepository myRepository;

    private Callback callback;

    private final static String TAG = "GetMyItemsInteractor";
    public GetMyItemsInteractor(Executor executor, MainThread mainThread, MyRepository myRepository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.myRepository = myRepository;
    }

    @Override
    public void execute(final Callback callback) {
        validateArguments(callback);
        this.callback = callback;
        this.executor.run(this);
    }

    private void validateArguments(Callback callback) {

        if (callback == null) {
            throw new IllegalArgumentException("Callback parameter can't be null");
        }
    }

    @Override
    public void run() {
        waitToDoThisSampleMoreInteresting();
        if (haveToShowError()) {
            notifyConnectionError();
        } else {
            searchMyItem();
        }
    }

    private void searchMyItem() {
        try {
            Log.i(TAG, "searchMyItem");
            Collection<MyItem> myItems = myRepository.getMyItemsCollection();
            nofityMyItemsLoaded(myItems);
        } catch (GetMyItemsException e) {
            notifyConnectionError();
        }
    }

    private boolean haveToShowError() {
        return false;//RandomUtils.percent(PERCENTAGE_OF_FAILS);
    }

    private void waitToDoThisSampleMoreInteresting() {
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            //Empty
        }
    }

    private void notifyConnectionError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void nofityMyItemsLoaded(final Collection<MyItem> myItems) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onMyItemsLoaded(myItems);
            }
        });
    }
}
