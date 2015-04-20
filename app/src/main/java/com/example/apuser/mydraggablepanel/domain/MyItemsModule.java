package com.example.apuser.mydraggablepanel.domain;

import com.example.apuser.mydraggablepanel.domain.interactor.GetMyItems;
import com.example.apuser.mydraggablepanel.domain.interactor.GetMyItemsInteractor;
import com.example.apuser.mydraggablepanel.domain.mock.MockMyRepository;
import com.example.apuser.mydraggablepanel.domain.repository.MyRepository;
import com.example.apuser.mydraggablepanel.domain.repository.MyService;
import com.example.apuser.mydraggablepanel.domain.repository.MyServiceResponseMapper;
import com.example.apuser.mydraggablepanel.domain.repository.RetrofitMyRepository;
import com.example.apuser.mydraggablepanel.executor.Executor;
import com.example.apuser.mydraggablepanel.executor.MainThread;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by apuser on 3/30/15.
 */
@Module(
        library = true,
        complete = false
)
public class MyItemsModule {
    @Provides
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("http://javatechig.com")
                .build();
    }

    @Provides
    MyServiceResponseMapper provideMyServiceResponseMapper() {
        return new MyServiceResponseMapper();
    }

    @Provides
    MyService provideMyService(RestAdapter restAdapter) {
        return restAdapter.create(MyService.class);
    }

    @Provides
    GetMyItems provideGetMyItemsInteractor(GetMyItemsInteractor interactor) {
        return interactor;
    }

    @Provides @Singleton @Named("product_repo")
    MyRepository provideRetrofitMyRepository(MyService myService,
                                                     MyServiceResponseMapper myServiceResponseMapper) {
        return new RetrofitMyRepository(myService, myServiceResponseMapper);
    }

    @Provides @Singleton @Named("mock_repo") MyRepository provideMockMyRepository() {
        return new MockMyRepository();
    }

    @Provides GetMyItemsInteractor provideGetMyItemsInteractor(Executor executor,
                                                               MainThread mainThread,
                                                               @Named("mock_repo") MyRepository myRepository) {
        return new GetMyItemsInteractor(executor, mainThread, myRepository);
    }
}
