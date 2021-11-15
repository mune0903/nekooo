package com.mune0903.nuko.core.di

import com.mune0903.nuko.BuildConfig
import com.mune0903.nuko.core.okhttp.ApiInterceptor
import com.mune0903.nuko.core.okhttp.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val apiInterceptor = ApiInterceptor(BuildConfig.API_HEADER, BuildConfig.API_KEY)
        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = LoggingInterceptor()
            OkHttpClient()
                .newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(apiInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient()
                .newBuilder()
                .addInterceptor(apiInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build()
        }
    }
}