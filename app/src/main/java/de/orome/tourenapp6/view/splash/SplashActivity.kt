package de.orome.tourenapp6.view.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.ActivitySplashBinding
import de.orome.tourenapp6.view.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mit Binding obsolet: setContentView(R.layout.activity_splash)

        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        // Anpassung, dass in allen Versionen Fullscreen funktioniert
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        // Ende Anpassung
        // TextViewanimieren
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        splashBinding.tvSplashScreenTitle.animation = splashAnimation
        // Listener einführen, um Animation in der Mitte des Bildschirmes zu halten
        splashAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                // eine Sekunde nach Ende der Animation zur StartActivity springen
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity,
                    HomeActivity::class.java))
                    // Splashscreen endgültig beenden
                    finish()
                },1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
    }
}