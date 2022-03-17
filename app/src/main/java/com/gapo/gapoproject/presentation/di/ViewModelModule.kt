package com.gapo.gapoproject.presentation.di

import com.gapo.gapoproject.domain.repository.NewsFeedRepository
import com.gapo.gapoproject.domain.usecase.GetNewsFeedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {
    @Provides
    @ViewModelScoped
    fun provideGetNewsFeedUseCase(newsFeedRepository: NewsFeedRepository) =
        GetNewsFeedUseCase(newsFeedRepository)
}
