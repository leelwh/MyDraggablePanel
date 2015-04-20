package com.example.apuser.mydraggablepanel.executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by apuser on 3/30/15.
 */
@Module(library = true)
public final class ExecutorModule {

    @Provides
    @Singleton
    Executor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }
}
