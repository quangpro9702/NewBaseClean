package com.gapo.gapoproject.data.di

import com.gapo.gapoproject.data.local.NewsFeedDataSource
import com.gapo.gapoproject.data.repo.NewsFeedResponseImpl
import com.gapo.gapoproject.domain.repository.NewsFeedRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun providerNewsFeedRepository(dataSource: NewsFeedDataSource): NewsFeedRepository {
        return NewsFeedResponseImpl(dataSource)
    }
}