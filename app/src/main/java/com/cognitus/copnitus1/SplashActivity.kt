package com.cognitus.copnitus1

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.cognitus.copnitus1.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
    }

    private val LOGO_SCALE_FACTOR = 1.2f
    private val LOGO_ANIMATE_REPEAT_TIMES = 3
    private val SPLASH_ANIMATION_DURATION_MILLIS:Long = 400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "0")


        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            binding.ivLogo ,
            PropertyValuesHolder.ofFloat("scaleX", LOGO_SCALE_FACTOR),
            PropertyValuesHolder.ofFloat("scaleY", LOGO_SCALE_FACTOR)
        )

        scaleDown.duration = SPLASH_ANIMATION_DURATION_MILLIS
        scaleDown.repeatCount = LOGO_ANIMATE_REPEAT_TIMES
        scaleDown.repeatMode = ObjectAnimator.REVERSE
        scaleDown.start()

        Handler(Looper.getMainLooper()).postDelayed({
            if (username === "0" ) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }

        }, 5000)
    }
}