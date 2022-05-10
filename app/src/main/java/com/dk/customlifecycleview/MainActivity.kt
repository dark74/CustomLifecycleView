package com.dk.customlifecycleview

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.dk.customlifecycleview.view.CustomView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addCustomView()
    }

    /**
     * 测试直接代码添加自定义View到页面中，context为applicationContext
     */
    private fun addCustomView() {
        //首先添加一个父布局
        val params: FrameLayout.LayoutParams =
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 300)
        val parent = FrameLayout(applicationContext)
        parent.setBackgroundColor(0x55ff0000)
        addContentView(parent, params)

        //添加CustomView
        val view = CustomView(applicationContext, null)
        view.setBackgroundColor(0x5500ff00)
        parent.addView(view, FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 200))
    }
}