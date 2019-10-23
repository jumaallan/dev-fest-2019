package com.androidstudy.devfest19

import android.os.Build
import androidx.annotation.Nullable
import com.androidstudy.devfest19.utils.timberLogger
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class DevFest19 : SplitCompatApplication() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initKoin()
        initStetho()
    }

    private fun initKoin() {
        startKoin {
            timberLogger()
            androidContext(applicationContext)
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