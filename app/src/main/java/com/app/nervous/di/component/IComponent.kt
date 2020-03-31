package com.app.nervous.di.component

import androidx.appcompat.app.AppCompatActivity

interface IComponent<T: AppCompatActivity> {
    fun inject(activity: T)
}