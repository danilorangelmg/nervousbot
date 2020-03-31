package com.app.nervous.di.component

import com.app.nervous.di.module.ChatModule
import com.app.nervous.di.scope.ActivityScope
import com.app.nervous.ui.chat.ChatActivity
import dagger.Component

/**
 * Created by danilorangel on 15/07/18.
 */
@ActivityScope
@Component(modules = [ChatModule::class], dependencies = [AppComponent::class])
interface ChatComponent: IComponent<ChatActivity> {
//    fun inject(activity: ChatActivity)
}