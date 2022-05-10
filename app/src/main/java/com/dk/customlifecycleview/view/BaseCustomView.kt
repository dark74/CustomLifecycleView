package com.dk.customlifecycleview.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import com.dk.customlifecycleview.view.fragment.AndroidXLifecycleFragment
import com.dk.customlifecycleview.view.fragment.IBaseLifecycleFragment
import com.dk.customlifecycleview.view.fragment.AppLifecycleFragment
import com.gaodun.gdwidget.dialog.custom.ActivityLifeListener

abstract class BaseCustomView(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addLifeListener(getLifeListener())
    }

    private fun addLifeListener(listener: ActivityLifeListener) {
        val fragment = getLifecycleFragment(this)
        fragment?.addListener(listener)
    }

    private fun getLifecycleFragment(view: View): IBaseLifecycleFragment? {
        return getActivity(view)?.let { activity ->
            val tag = this.javaClass.canonicalName
            Log.d("BaseCustomView", "tag:$tag")
            if (activity is FragmentActivity) {
                val fm = activity.supportFragmentManager
                val fragment = fm.findFragmentByTag(tag)
                if (fragment == null) {
                    val newFragment = AndroidXLifecycleFragment()
                    fm.beginTransaction().add(newFragment, tag).commitAllowingStateLoss()
                    newFragment
                } else {
                    fragment as AppLifecycleFragment?
                }
            } else {
                val fm = activity.fragmentManager
                val fragment = fm.findFragmentByTag(tag)
                if (fragment == null) {
                    val newFragment = AppLifecycleFragment()
                    fm.beginTransaction().add(newFragment, tag).commitAllowingStateLoss()
                    newFragment
                } else {
                    fragment as AppLifecycleFragment?
                }
            }
        }
    }

    private fun getActivity(view: View): Activity? {
        var parentView = view
        var activity: Activity? = null
        while (parentView != null) {
            val context = parentView.context
            Log.d("CustomView", "parentView:${parentView},context:${context}")
            if (context != null && context is Activity) {
                activity = context
                break
            }
            parentView = parentView.parent as View
        }
        return activity
    }

    protected abstract fun getLifeListener(): ActivityLifeListener
}