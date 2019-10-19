package com.androidstudy.devfest19.utils

import org.koin.core.KoinApplication
import org.koin.core.logger.KOIN_TAG
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

private class TimberLogger(level: Level = Level.INFO) : Logger(level) {

    override fun log(level: Level, msg: MESSAGE) {
        if (this.level <= level) {
            when (this.level) {
                Level.DEBUG -> Timber.tag(KOIN_TAG).d(msg)
                Level.INFO -> Timber.tag(KOIN_TAG).i(msg)
                Level.ERROR -> Timber.tag(KOIN_TAG).e(msg)
            }
        }
    }

}

fun KoinApplication.timberLogger(level: Level = Level.INFO): KoinApplication {
    KoinApplication.logger = TimberLogger(level)
    return this
}