package com.gapo.gapoproject.data.di

import android.content.Context
import com.gapo.gapoproject.data.local.NewsFeedDataSource
import com.gapo.gapoproject.data.local.NewsFeedDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class DataSourceModule {
    @Provides
    fun providerNewsFeedDataSource(
        @ApplicationContext context: Context
    ): NewsFeedDataSource {
        return NewsFeedDataSourceImpl(context)
    }
}