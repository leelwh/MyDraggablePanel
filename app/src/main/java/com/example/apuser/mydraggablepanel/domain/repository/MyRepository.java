package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.GetMyItemsException;
import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.Collection;
import java.util.List;

/**
 * Created by apuser on 3/30/15.
 */
public interface MyRepository {
    Collection<MyItem> getMyItemsCollection() throws GetMyItemsException;
}
