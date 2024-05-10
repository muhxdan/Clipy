package com.salty.apps.clipy.di

import com.salty.apps.clipy.domain.repository.Repository
import com.salty.apps.clipy.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideUseCase(repository: Repository): UseCase = UseCase(repository)
}