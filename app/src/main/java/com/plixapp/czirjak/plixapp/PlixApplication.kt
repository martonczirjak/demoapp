package com.plixapp.czirjak.plixapp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration



class PlixApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
                .name("tasky.realm")
                .schemaVersion(0)
                .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}