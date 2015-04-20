package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by apuser on 3/31/15.
 */
public interface MyService {
    @GET("/api/get_category_posts/?dev=1&slug=android")
    MyServiceResponse listMyItem();
}
