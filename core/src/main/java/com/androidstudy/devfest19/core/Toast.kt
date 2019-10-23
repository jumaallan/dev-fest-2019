package com.androidstudy.devfest19.core

import android.app.Activity
import android.widget.Toast

private var toast: Toast? = null

fun Activity.toast(message: CharSequence) {
    toast?.cancel()
    toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        .apply { show() }
}

