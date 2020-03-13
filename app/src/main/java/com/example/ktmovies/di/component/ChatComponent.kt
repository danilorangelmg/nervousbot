package com.example.ktmovies.di.component

import com.example.ktmovies.di.module.ChatModule
import com.example.ktmovies.di.module.ViewModelModule
import com.example.ktmovies.di.scope.ActivityScope
import com.example.ktmovies.ui.chat.ChatActivity
import dagger.Component

/**
 * Created by danilorangel on 15/07/18.
 */
@ActivityScope
@Component(modules = [ChatModule::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface ChatComponent {

    fun inject(activity: ChatActivity?)
}