package com.example.ktmovies.di.component

import androidx.appcompat.app.AppCompatActivity
import com.example.ktmovies.di.module.ChatModule
import com.example.ktmovies.di.scope.ActivityScope
import com.example.ktmovies.ui.chat.ChatActivity
import dagger.Component

interface IComponent<T: AppCompatActivity> {
    fun inject(activity: T)
}