package com.androidstudy.devfest19

import android.os.Build
import androidx.annotation.Nullable
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import timber.log.Timber

class DevFest19 : SplitCompatApplication() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
        initStetho()
    }

    private fun initKoin() {
        try {
            startKoin {
                androidLogger()
                androidContext(applicationContext)
            }
        } catch (error: KoinAppAlreadyStartedException) {
            Timber.e(error.localizedMessage)
        }
    }

    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {
            @Nullable
            override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                return super.createStackElementTag(element) + ":" + element.lineNumber
            }
        })
    }

    private fun initStetho() {
        if (!isRoboUnitTest() && BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun isRoboUnitTest(): Boolean {
        return "robolectric" == Build.FINGERPRINT
    }

}