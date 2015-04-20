package com.example.apuser.mydraggablepanel.domain.interactor;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.Collection;

/**
 * Created by apuser on 3/30/15.
 */
public interface GetMyItems {
    interface Callback {
        void onMyItemsLoaded(final Collection<MyItem> myItems);

        void onConnectionError();
    }

    void execute(final Callback callback);
}
