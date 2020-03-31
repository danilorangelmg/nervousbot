package com.app.nervous.di.module

import com.app.nervous.rest.impl.ChatRepositoryImpl
import com.app.nervous.rest.repository.ChatRepository
import com.app.nervous.rest.retrofit_service.ServiceApi
import com.app.nervous.ui.chat.ChatViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by danilorangel on 15/07/18.
 */
@Module
class ChatModule() {

    @Provides
    fun providePresenter(repository: ChatRepository): ChatViewModel {
        return ChatViewModel(repository)
    }

    @Provides
    fun provideRepository(serviceApi: ServiceApi): ChatRepository {
        return ChatRepositoryImpl(serviceApi)
    }
}