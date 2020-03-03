package com.example.ktmovies

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.ktmovies.di.component.AppComponent
import com.example.ktmovies.di.component.DaggerAppComponent
import com.example.ktmovies.di.module.AppModule

/**
 * Created by danilorangel on 7/13/18.
 */
class KtMovieApplication: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


}