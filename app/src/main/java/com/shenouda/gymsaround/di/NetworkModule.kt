package com.shenouda.gymsaround.di

import com.shenouda.gymsaround.data.remote.apis.GymsApiService
import com.shenouda.gymsaround.data.repository.GymsRepositoryImpl
import com.shenouda.gymsaround.domain.repository.GymsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // 🔥 الحل هنا
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cairo-gyms-64f2f-default-rtdb.firebaseio.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // 👈 استخدم Moshi
            .build()
    }

    @Provides
    @Singleton
    fun provideGymApiService(retrofit: Retrofit):GymsApiService{
        return retrofit.create(GymsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGymsRepository(gymsApiService: GymsApiService):GymsRepository{
        return GymsRepositoryImpl(gymsApiService)
    }



}