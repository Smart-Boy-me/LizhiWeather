package com.lizhiweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class LizhiWeatherApplication : Application() {
    companion object{
        const val TOKEN = "AOIaG0Kw7717es2W"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}