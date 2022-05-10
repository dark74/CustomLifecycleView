package com.dk.customlifecycleview.view.fragment

import android.app.Fragment
import android.os.Bundle
import com.gaodun.gdwidget.dialog.custom.ActivityLifeListener

/**
 * 继承android.app包的Fragment
 */
class AppLifecycleFragment : Fragment(), IBaseLifecycleFragment {
    private var listenerList: ArrayList<ActivityLifeListener>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getListeners()?.forEach {
            it.onCreate(savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
        getListeners()?.forEach {
            it.onStart()
        }
    }

    override fun onResume() {
        super.onResume()
        getListeners()?.forEach {
            it.onResume()
        }
    }

    override fun onPause() {
        super.onPause()
        getListeners()?.forEach {
            it.onPause()
        }
    }

    override fun onStop() {
        super.onStop()
        getListeners()?.forEach {
            it.onStop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        getListeners()?.forEach {
            it.onDestroy()
        }
    }

    override fun getListeners(): ArrayList<ActivityLifeListener>? {
        if (listenerList == null) {
            listenerList = arrayListOf()
        }
        return listenerList
    }
}