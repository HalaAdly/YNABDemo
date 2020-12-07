package com.hm.ynabdemo.di


import com.hm.ynabdemo.TestDataRepository
import com.hm.ynabdemo.data.DataRepositorySource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class TestDataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: TestDataRepository): DataRepositorySource
}
