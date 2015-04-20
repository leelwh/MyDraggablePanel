package com.example.apuser.mydraggablepanel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apuser on 3/30/15.
 */
public class MyRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;

    public MyRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
    }
}
