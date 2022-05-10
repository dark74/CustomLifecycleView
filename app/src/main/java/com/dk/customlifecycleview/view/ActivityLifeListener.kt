package com.gaodun.gdwidget.dialog.custom

import android.os.Bundle

interface ActivityLifeListener {
    fun onCreate(bundle: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}