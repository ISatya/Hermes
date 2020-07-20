package com.droid.hermes.di

import com.droid.hermes.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created on 19/07/20.
 */
@InstallIn(ApplicationComponent::class)
@Module
internal class NetworkModule {

    companion object{
        const val ENDPOINT = "https://www.thesportsdb.com/api/v1/json/1/"
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor)
            = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun providesLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

    @Provides
    @Singleton
    fun providesMoshiConverterFactory() = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

}