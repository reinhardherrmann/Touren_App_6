package de.orome.tourenapp6.view.touren

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.ActivityAddUpdateTourBinding

class AddUpdateTourActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityAddUpdateTourBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivityAddUpdateTourBinding.inflate(layoutInflater)
        setUpActionBar()
        setContentView(mbinding.root)
    }








    @SuppressLint("RestrictedApi")
    fun setUpActionBar(){
        setSupportActionBar(mbinding.toolbarAddUpdateTourActivity)
        // Back-Button anzeigen
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        //mbinding.toolbarAddUpdateTourActivity.setTitleTextColor(0xFFFFFFF)
        // ClickListener für BackButton
        mbinding.toolbarAddUpdateTourActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}