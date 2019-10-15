package com.androidstudy.devfest19

import android.app.Application
import androidx.annotation.Nullable
import org.jetbrains.annotations.NotNull
import timber.log.Timber

class DevFest19 : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    private fun initKoin() {

    }

    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {
            @Nullable
            override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                return super.createStackElementTag(element) + ":" + element.lineNumber
            }
        })
    }

}