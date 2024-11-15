package com.tripplanner.application

import android.app.Application
import com.google.firebase.FirebaseApp
import com.tripplanner.db.AppDatabase


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        myApplication=this
            }

    companion object{
        lateinit var myApplication: MyApplication
    }
}