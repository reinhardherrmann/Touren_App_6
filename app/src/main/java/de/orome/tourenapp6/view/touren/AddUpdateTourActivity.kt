package de.orome.tourenapp6.view.touren

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.ActivityAddUpdateTourBinding
import java.util.*

class AddUpdateTourActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mbinding: ActivityAddUpdateTourBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivityAddUpdateTourBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        setUpActionBar()
        mbinding.fabSaveTour.setOnClickListener(this)

        // ------- OnClickListener für TextFelder --------------------------------
        mbinding.etAddUpdateTourTourdatum.setOnClickListener {
            val c = Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                    v,year,month,day ->
                val dat=day.toString() + "." + month.toString() + "." + year.toString()
                mbinding.etAddUpdateTourTourdatum
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},year,month,day
            )
            dpd.show()
        }

        mbinding.etAddUpdateTourTourdauer.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 3 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }
                val dat= "$hh:$mm"
                mbinding.etAddUpdateTourTourdauer
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mbinding.etAddUpdateTourDepotzeitVT.setOnClickListener {
            // TODO Standardzeit für Depotzeit vor Tour auf 01:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 1 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                val dat= "$hh:$mm"
                mbinding.etAddUpdateTourDepotzeitVT
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mbinding.etAddUpdateTourDepotzeitNT.setOnClickListener {
            // TODO Standardzeit für Depotzeit nach Tour auf 00:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 0 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                val dat= "$hh:$mm"
                mbinding.etAddUpdateTourDepotzeitNT
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        // -------Ende OnClickListener für TextFelder ----------------------------

    }




    //------------------------- OnClickListener für alle Views der Activity -----------
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(v: View?) {
        if (v != null){
            when(v.id){
                // Wenn FloatingActionButton geclickt wurde....
                R.id.fab_save_tour -> {
                    Toast.makeText(this,
                        "Tour ${mbinding.etAddUpdateTourTournummer.text.toString()} gespeichert.",
                        Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }
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


