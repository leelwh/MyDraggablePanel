package com.example.apuser.mydraggablepanel.domain.repository;

import com.example.apuser.mydraggablepanel.domain.GetMyItemsException;
import com.example.apuser.mydraggablepanel.domain.model.MyItem;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit.RestAdapter;

/**
 * Created by apuser on 3/30/15.
 */
public class RetrofitMyRepository implements MyRepository{
    private final MyService myService;
    private final MyServiceResponseMapper myServiceResponseMapper;

    public RetrofitMyRepository(MyService myService,
                                MyServiceResponseMapper myServiceResponseMapper) {
        this.myService = myService;
        this.myServiceResponseMapper = myServiceResponseMapper;
    }

    @Override
    public List<MyItem> getMyItemsCollection() throws GetMyItemsException {
        MyServiceResponse myServiceResponse = myService.listMyItem();
        return myServiceResponseMapper.mapResponse(myServiceResponse);
    }
}
