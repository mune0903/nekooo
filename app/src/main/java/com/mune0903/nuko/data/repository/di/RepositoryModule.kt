package com.mune0903.nuko.data.repository.di

import com.mune0903.nuko.data.repository.CatRepository
import com.mune0903.nuko.data.repository.CatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCatRepository(impl: CatRepositoryImpl): CatRepository
}