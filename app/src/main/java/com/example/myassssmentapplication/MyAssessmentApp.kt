package com.example.myassssmentapplication

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyAssessmentApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyAssessmentApp)
            modules(appModule)
        }
    }
}
