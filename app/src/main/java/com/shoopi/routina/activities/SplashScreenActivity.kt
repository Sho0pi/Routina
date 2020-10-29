package com.shoopi.routina.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.shoopi.routina.MainActivity
import com.shoopi.routina.R

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_TIMEOUT: Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setBackgroundDrawable(null)

        Handler().postDelayed(
            Runnable {
                startActivity(
                    Intent(this, MainActivity::class.java),
                    ActivityOptions.makeCustomAnimation(
                        this,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    ).toBundle()
                )
                finish()
            },
            SPLASH_SCREEN_TIMEOUT
        )
    }
}