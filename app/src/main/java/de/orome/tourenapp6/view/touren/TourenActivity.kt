package de.orome.tourenapp6.view.touren

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.idescout.sql.SqlScoutServer
import de.orome.tourenapp6.R
import de.orome.tourenapp6.viewmodel.TourenViewModel

class TourenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SqlScoutServer.create(this, getPackageName())
        setContentView(R.layout.activity_touren)
    }

}