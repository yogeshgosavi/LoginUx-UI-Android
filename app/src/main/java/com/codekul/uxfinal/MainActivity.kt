package com.codekul.uxfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.graphics.drawable.Drawable
import android.os.Build
import android.app.Activity
import android.annotation.TargetApi
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarGradiant(this)

        setContentView(R.layout.activity_main)


        btnSignUP.setOnClickListener {
            startActivity(
                    Intent(this,SignUpActivity::class.java)
            )
        }

        btnlogin.setOnClickListener {
            startActivity(
                    Intent(this,LoginActivity::class.java)
            )
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBarGradiant(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            val background = activity.resources.getDrawable(R.drawable.gradient_color)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = activity.resources.getColor(android.R.color.transparent)
            window.navigationBarColor = activity.resources.getColor(android.R.color.transparent)
            window.setBackgroundDrawable(background)

        }
    }
}
