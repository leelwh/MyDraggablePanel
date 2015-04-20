package com.example.apuser.mydraggablepanel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by apuser on 3/30/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRowHolder> {
    private List<MyItem> myItemList;
    private View.OnClickListener onClickListener;
    private Context mContext;

    public MyRecyclerAdapter(List<MyItem> myItemList, Context mContext) {
        this.myItemList = myItemList;
        this.mContext = mContext;
    }

    public MyRecyclerAdapter(Context mContext, View.OnClickListener onClickListener) {
        myItemList = new ArrayList<MyItem>();
        this.mContext = mContext;
        this.onClickListener = onClickListener;
    }

    @Override
    public MyRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
        v.setOnClickListener(onClickListener);
        MyRowHolder mh = new MyRowHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(MyRowHolder holder, int position) {
        MyItem myItem = myItemList.get(position);

        Picasso.with(mContext).load(myItem.getThumbnail())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);
    }

    public void add(MyItem myItem) {
        myItemList.add(myItem);
        notifyDataSetChanged();
    }

    public void add(Collection<MyItem> myItems) {
        this.myItemList.addAll(myItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != myItemList ? myItemList.size() : 0);
    }
}
