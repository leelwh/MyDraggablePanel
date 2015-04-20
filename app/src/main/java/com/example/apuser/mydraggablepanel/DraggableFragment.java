package com.example.apuser.mydraggablepanel;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.github.pedrovgs.DraggableView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by apuser on 3/31/15.
 */
public class DraggableFragment extends BaseFragment implements DraggablePresenter.View {
    @Inject DraggablePresenter draggablePresenter;
    @InjectView(R.id.draggable_view) DraggableView draggableView;
    @InjectView(R.id.text_view) TextView textView;
    @InjectView(R.id.image_view) ImageView imageView;
    private MyItem myItem;
    @Override
    protected int getFragmentLayout() {
        return R.layout.draggable_view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        draggablePresenter.setView(this);
    }

    public void showMyItem(MyItem myItem) {
        this.myItem = myItem;
        imageView.setVisibility(View.VISIBLE);
        Picasso.with(getActivity())
                .load(myItem.getThumbnail())
                .placeholder(R.color.main_color)
                .into(imageView);
        textView.setVisibility(View.VISIBLE);
        textView.setText(myItem.getTitle());
        draggableView.setVisibility(View.VISIBLE);
        draggableView.maximize();
    }
}
