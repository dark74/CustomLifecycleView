package com.dk.customlifecycleview.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import com.dk.customlifecycleview.R
import com.gaodun.gdwidget.dialog.custom.ActivityLifeListener

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0,
) : BaseCustomView(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.custom_view_layout, this)
    }

    override fun getLifeListener(): ActivityLifeListener {
        return object : ActivityLifeListener {
            override fun onCreate(bundle: Bundle?) {
                Log.d("CustomView", "onCreate")
            }

            override fun onStart() {
                Log.d("CustomView", "onStart")
            }

            override fun onResume() {
                Log.d("CustomView", "onResume")
            }

            override fun onPause() {
                Log.d("CustomView", "onPause")
            }

            override fun onStop() {
                Log.d("CustomView", "onStop")
            }

            override fun onDestroy() {
                Log.d("CustomView", "onDestroy")
            }
        }
    }

}