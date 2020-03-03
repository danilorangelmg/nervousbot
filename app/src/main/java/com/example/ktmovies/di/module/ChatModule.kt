package com.example.ktmovies.di.module

import com.example.ktmovies.contract.ChatContract
import com.example.ktmovies.rest.impl.ChatRepositoryImpl
import com.example.ktmovies.rest.repository.ChatRepository
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import com.example.ktmovies.ui.chat.ChatPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by danilorangel on 15/07/18.
 */
@Module
class ChatModule(private val mView: ChatContract.View) {

    @Provides
    fun provideView(): ChatContract.View {
        return mView
    }

    @Provides
    fun providePresenter(view: ChatContract.View, repository: ChatRepository): ChatContract.Presenter {
        return ChatPresenter(view, repository)
    }

    @Provides
    fun provideRepository(serviceApi: ServiceApi): ChatRepository {
        return ChatRepositoryImpl(serviceApi)
    }
}