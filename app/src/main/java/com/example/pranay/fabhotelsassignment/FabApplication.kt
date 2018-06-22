package com.example.pranay.fabhotelsassignment

import android.app.Application
import android.content.Context
import com.example.pranay.fabhotelsassignment.injection.component.ApplicationComponent
import com.example.pranay.fabhotelsassignment.injection.component.DaggerApplicationComponent
import com.example.pranay.fabhotelsassignment.injection.module.ApplicationModule

/**
 * Created by pranay on 21/06/18.
 */
class FabApplication : Application(){

    private val mApplicationComponent : ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent.inject(this)
    }

    fun getApplictionComponent(): ApplicationComponent {
        return mApplicationComponent
    }

    companion object {
        fun get(context: Context) : FabApplication{
            return context.applicationContext as FabApplication
        }
    }
}