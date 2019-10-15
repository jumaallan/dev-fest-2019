@file:JvmName("ActivityHelper")

package com.androidstudy.devfest19.utils

import android.content.Intent
import com.androidstudy.devfest19.utils.Constants.PACKAGE_NAME

// Helpers to start activities in a modularized world.


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
            override val className = "com.androidstudy.movie"
        }

    }

    /**
     * Base object for Music Module Activities.
     */
    object MusicModule {

        object Music : AddressableActivity {
            override val className = "com.androidstudy.music"
        }

    }

    /**
     * Base object for News Module Activities.
     */
    object NewsModule {

        object News : AddressableActivity {
            override val className = "com.androidstudy.news"
        }

    }

    /**
     * Base object for Weather Module Activities.
     */
    object WeatherModule {

        object Weather : AddressableActivity {
            override val className = "com.androidstudy.weather"
        }

    }

}