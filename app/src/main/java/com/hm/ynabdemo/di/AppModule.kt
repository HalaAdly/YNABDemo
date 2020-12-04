package com.hm.ynabdemo.di


import com.hm.ynabdemo.App
import com.hm.ynabdemo.utils.Network
import com.hm.ynabdemo.utils.NetworkConnectivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {
//    @Provides
//    @Singleton
//    fun provideLocalRepository(): LocalData {
//        return LocalData()
//    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivity(): NetworkConnectivity {
        return Network(App.context)
    }
}
