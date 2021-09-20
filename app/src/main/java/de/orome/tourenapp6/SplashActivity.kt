package de.orome.tourenapp6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.orome.tourenapp6.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mit Binding obsolet: setContentView(R.layout.activity_splash)

        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
    }
}