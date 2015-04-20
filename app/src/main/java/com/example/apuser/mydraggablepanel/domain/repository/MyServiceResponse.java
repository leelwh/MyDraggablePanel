package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.List;

/**
 * Created by apuser on 3/31/15.
 */
public class MyServiceResponse {
    String status;
    List<MyItem> posts;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPosts(List<MyItem> posts) {
        this.posts = posts;
    }

    public String getStatus() {

        return status;
    }

    public List<MyItem> getPosts() {
        return posts;
    }
}
