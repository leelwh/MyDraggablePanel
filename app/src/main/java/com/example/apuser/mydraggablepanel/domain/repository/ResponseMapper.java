package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.List;

/**
 * Created by apuser on 3/31/15.
 */
public interface ResponseMapper<T> {
    List<MyItem> mapResponse(T response);
}
