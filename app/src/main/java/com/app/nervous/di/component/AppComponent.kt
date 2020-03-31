package com.app.nervous.di.component

import android.content.Context
import com.app.nervous.KtMovieApplication
import com.app.nervous.di.module.AppModule
import com.app.nervous.di.module.NetworkModule
import com.app.nervous.di.qualifier.ApplicationContext
import com.app.nervous.di.scope.ApplicationScope
import com.app.nervous.rest.retrofit_service.ServiceApi
import dagger.Component

/**
 * Created by danilorangel on 7/13/18.
 */
@ApplicationScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getApiInterface(): ServiceApi

    @ApplicationContext
    fun getContext(): Context

    fun injectApplication(myApplication: KtMovieApplication)

}