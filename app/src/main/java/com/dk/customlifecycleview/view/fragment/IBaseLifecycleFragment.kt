package com.dk.customlifecycleview.view.fragment

import com.gaodun.gdwidget.dialog.custom.ActivityLifeListener

interface IBaseLifecycleFragment {
    fun getListeners(): ArrayList<ActivityLifeListener>?

    fun addListener(listener: ActivityLifeListener?) {
        listener?.apply {
            if (getListeners()?.contains(listener) != true) {
                getListeners()?.add(listener)
            }
        }
    }

    fun removeListener(listener: ActivityLifeListener?) {
        listener?.apply {
            if (getListeners()?.contains(listener) == true) {
                getListeners()?.remove(listener)
            }
        }
    }
}