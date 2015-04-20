package com.example.apuser.mydraggablepanel.domain.model;

/**
 * Created by apuser on 3/30/15.
 */
public class MyItem {
    String title;
    String thumbnail;

    public MyItem() {
    }

    public MyItem(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
