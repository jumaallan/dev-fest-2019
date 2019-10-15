@file:JvmName("ActivityHelper")

package com.androidstudy.devfest19.utils

import android.content.Intent

/**
 * Helpers to start activities in a modularized world.
 */

private const val PACKAGE_NAME = "com.androidstudy.devfest19"


/**
 * Create an Intent with [Intent.ACTION_VIEW] to an [AddressableActivity].
 */
fun intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className
    )
}

/**
 * An [android.app.Activity] that can be addressed by an intent.
 */
interface AddressableActivity {
    /**
     * The activity class name.
     */
    val className: String
}

/**
 * All addressable activities.
 *
 * Can contain intent extra names or functions associated with the activity creation.
 */

object Activities {

    /**
     * Base object for Movie Module Activities.
     */
    object MovieModule {

        object Movie : AddressableActivity {
            override val className = "com.androidstudy.movie.ui.views.MovieActivity"
        }

    }

    /**
     * Base object for Music Module Activities.
     */
    object MusicModule {

        object Music : AddressableActivity {
            override val className = "com.androidstudy.music.ui.views.MusicActivity"
        }

    }

    /**
     * Base object for News Module Activities.
     */
    object NewsModule {

        object News : AddressableActivity {
            override val className = "com.androidstudy.news.ui.views.NewsActivity"
        }

    }

    /**
     * Base object for Weather Module Activities.
     */
    object WeatherModule {

        object Weather : AddressableActivity {
            override val className = "com.androidstudy.weather.ui.views.WeatherActivity"
        }

    }

}