package com.example.ktmovies.di.module

import android.content.Context
import com.example.ktmovies.di.qualifier.ApplicationContext
import com.example.ktmovies.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by danilorangel on 7/13/18.
 */
@Module
class AppModule(private val context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }
}