package com.tripplanner.ui


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tripplanner.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        // Set a delay for the splash screen before moving to the next activity
        Handler().postDelayed({
            // Start the main activity (or any other activity you want)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()  // Optional: finishes the splash screen activity so it can't be returned to
        }, 3000)  // Delay time in milliseconds (3 seconds)
    }
}
