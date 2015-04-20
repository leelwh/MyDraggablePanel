package com.example.apuser.mydraggablepanel;

import com.example.apuser.mydraggablepanel.domain.interactor.GetMyItems;
import com.example.apuser.mydraggablepanel.domain.model.MyItem;
import com.example.apuser.mydraggablepanel.domain.model.MyItemList;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by apuser on 3/30/15.
 */
@Singleton
public class MainPresenter extends Presenter {
    private GetMyItems getMyItemsInteractor;
    private View view;
    private MyItemList myItemList;
    @Inject
    public MainPresenter(GetMyItems getMyItemsInteractor) {
        this.getMyItemsInteractor = getMyItemsInteractor;
    }

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        this.view = view;
    }

    @Override
    public void initialize() {
        checkViewAlreadySetted();
        myItemList = new MyItemList();
        loadMyItems();
    }
    public void onMyItemClicked(int position) {
        view.openMyItem(myItemList.get(position));
    }

    private void checkViewAlreadySetted() {
        if (view == null) {
            throw new IllegalArgumentException("Remember to set a view for this presenter");
        }
    }

    private void loadMyItems() {
        if (view.isReady()) {
            view.showLoading();
        }
        getMyItemsInteractor.execute(new GetMyItems.Callback() {

            @Override
            public void onMyItemsLoaded(Collection<MyItem> myItems) {
                myItemList.addAll(myItems);
                showMyItems(myItems);
            }

            @Override
            public void onConnectionError() {
                notifyConnectionError();
            }
        });
    }

    private void notifyConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
            view.hideLoading();
            view.showConnectionErrorMessage();
            view.showEmptyCase();
            view.showDefaultTitle();
        }
    }

    private void showMyItems(Collection<MyItem> myItems) {
        if (view.isReady()) {
            view.renderMyItems(myItems);
            view.hideLoading();
            view.updateTitleWithCountOfTvShows(myItems.size());
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public interface View {
        void hideLoading();

        void showLoading();

        void renderMyItems(final Collection<MyItem> myItems);

        void updateTitleWithCountOfTvShows(final int counter);

        void showConnectionErrorMessage();

        void showEmptyCase();

        void showDefaultTitle();

        void showMyItemsTitleAsMessage(MyItem myItem);

        void openMyItem(MyItem myItem);

        boolean isReady();

        boolean isAlreadyLoaded();
    }
}


