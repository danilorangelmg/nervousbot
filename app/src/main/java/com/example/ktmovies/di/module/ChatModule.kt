package com.example.ktmovies.di.module

import com.example.ktmovies.rest.impl.ChatRepositoryImpl
import com.example.ktmovies.rest.repository.ChatRepository
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import dagger.Module
import dagger.Provides

/**
 * Created by danilorangel on 15/07/18.
 */
@Module
class ChatModule {

    @Provides
    fun provideRepository(serviceApi: ServiceApi): ChatRepository {
        return ChatRepositoryImpl(serviceApi)
    }
}