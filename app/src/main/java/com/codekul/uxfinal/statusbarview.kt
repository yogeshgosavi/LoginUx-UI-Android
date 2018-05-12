package com.codekul.uxfinal

import android.content.Context
import android.view.View.MeasureSpec
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN


class StatusBarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private var mStatusBarHeight: Int = 0

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSystemUiVisibility(SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mStatusBarHeight = insets.systemWindowInsetTop
            return insets.consumeSystemWindowInsets()
        }
        return insets
    }

     override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mStatusBarHeight)
    }
}