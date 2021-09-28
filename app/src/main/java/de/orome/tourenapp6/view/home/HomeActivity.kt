package de.orome.tourenapp6.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.ActivityHomeBinding
import de.orome.tourenapp6.view.touren.TourenActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnCallTouren.setOnClickListener(this)
    }



    // ---------- OnClickListener für alle Buttons und Views ------------------------
    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.btnCallTouren -> {
                    startActivity(Intent(this,TourenActivity::class.java))
                }
            }
        }

    }
}