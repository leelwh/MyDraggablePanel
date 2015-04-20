package com.example.apuser.mydraggablepanel;

import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import javax.inject.Inject;

/**
 * Created by apuser on 3/31/15.
 */
public class DraggablePresenter extends Presenter {
    private View view;

    @Inject
    public DraggablePresenter() {
    }

    public void setView(View view) {
        this.view = view;
    }
    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public interface View {
    }
}
