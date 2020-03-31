package com.app.nervous

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.app.nervous.di.component.AppComponent
import com.app.nervous.di.component.DaggerAppComponent
import com.app.nervous.di.module.AppModule

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