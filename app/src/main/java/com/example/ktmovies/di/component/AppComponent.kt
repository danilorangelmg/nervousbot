package com.example.ktmovies.di.component

import android.content.Context
import com.example.ktmovies.KtMovieApplication
import com.example.ktmovies.di.module.AppModule
import com.example.ktmovies.di.module.NetworkModule
import com.example.ktmovies.di.qualifier.ApplicationContext
import com.example.ktmovies.di.scope.ApplicationScope
import com.example.ktmovies.rest.retrofit_service.ServiceApi
import dagger.Component

/**
 * Created by danilorangel on 7/13/18.
 */
@ApplicationScope
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {

    fun getApiInterface(): ServiceApi

    @ApplicationContext
    fun getContext(): Context

    fun injectApplication(myApplication: KtMovieApplication)

}