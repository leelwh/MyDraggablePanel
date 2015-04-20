package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.List;

/**
 * Created by apuser on 3/31/15.
 */
public class MyServiceResponseMapper implements ResponseMapper<MyServiceResponse> {
    @Override
    public List<MyItem> mapResponse(MyServiceResponse response) {
        List<MyItem> myItems = response.getPosts();

        return myItems;
    }
}
