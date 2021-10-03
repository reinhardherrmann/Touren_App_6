package de.orome.tourenapp6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import de.orome.tourenapp6.application.TourenApplication
import de.orome.tourenapp6.databinding.ActivityNewTourBinding
import de.orome.tourenapp6.helper.Helper
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.view.touren.TourenActivity
import de.orome.tourenapp6.viewmodel.TourenViewModel
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory
import java.util.*

class NewTourActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityNewTourBinding
    private val tourenViewModel: TourenViewModel by viewModels {
        tourenViewModelFactory((application as TourenApplication).repository)
    }

    val helper = Helper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dat: String = " "
        var std: String = ""
        var minute: String = ""
        var tag: String = ""
        var monat: String = ""

        mBinding = ActivityNewTourBinding.inflate(layoutInflater)
        //setupActionBar()  TODO ggf. erstellen

        // onClickListener zuordnen
        mBinding.etNewTourTourDatum.setOnClickListener(this)
        mBinding.etNewTourTourDauer.setOnClickListener(this)
        mBinding.etNewTourTourDepotzeitVt.setOnClickListener(this)
        mBinding.etNewTourTourDepotzeitNt.setOnClickListener(this)
        mBinding.etNewTourTourFahrtzeit.setOnClickListener(this)
        mBinding.etNewTourTourStandzeitKunde.setOnClickListener(this)
        mBinding.fabSaveNewTour.setOnClickListener(this)

        setContentView(mBinding.root)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.et_new_tour_tour_datum -> {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    this, DatePickerDialog.OnDateSetListener { v, year, month, day ->

                        val tag = helper.modifyMinuteHourDayMonth(day)
                        val monat = helper.modifyMinuteHourDayMonth(month + 1)

                        val dat = tag + "." + monat + "." + year.toString()
                        mBinding.etNewTourTourDatum.setText(
                            dat,
                            TextView.BufferType.EDITABLE
                        );
                    }, year, month, day
                )
                dpd.show()
            }

            R.id.et_new_tour_tour_dauer -> {
                // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    this, TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        val std = helper.modifyMinuteHourDayMonth(hh)
                        val minute = helper.modifyMinuteHourDayMonth(mm)
                        val dat = "$std:$minute"

                        mBinding.etNewTourTourDauer
                            .setText(
                                dat,
                                TextView.BufferType.EDITABLE
                            );
                    }, hh, mm, true
                )
                dpd.show()
            }

            R.id.et_new_tour_tour_depotzeit_vt -> {
                val c = Calendar.getInstance()
                val hh = 1 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    this, TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        val std = helper.modifyMinuteHourDayMonth(hh)
                        val minute = helper.modifyMinuteHourDayMonth(mm)
                        val dat = "$std:$minute"

                        mBinding.etNewTourTourDepotzeitVt
                            .setText(
                                dat,
                                TextView.BufferType.EDITABLE
                            );
                    }, hh, mm, true
                )
                dpd.show()
            }

            R.id.et_new_tour_tour_depotzeit_nt -> {
                // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 0 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    this, TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        val std = helper.modifyMinuteHourDayMonth(hh)
                        val minute = helper.modifyMinuteHourDayMonth(mm)
                        val dat = "$std:$minute"

                        mBinding.etNewTourTourDepotzeitNt
                            .setText(
                                dat,
                                TextView.BufferType.EDITABLE
                            );
                    }, hh, mm, true
                )
                dpd.show()
            }

            R.id.et_new_tour_tour_fahrtzeit -> {
                // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
                val c = Calendar.getInstance()
                val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    this, TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        val std = helper.modifyMinuteHourDayMonth(hh)
                        val minute = helper.modifyMinuteHourDayMonth(mm)
                        val dat = "$std:$minute"

                        mBinding.etNewTourTourFahrtzeit
                            .setText(
                                dat,
                                TextView.BufferType.EDITABLE
                            );
                    }, hh, mm, true
                )
                dpd.show()
            }

            R.id.et_new_tour_tour_standzeit_kunde -> {
                val c = Calendar.getInstance()
                val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
                val mm = 25 //c.get(Calendar.MINUTE)

                val dpd = TimePickerDialog(
                    this, TimePickerDialog.OnTimeSetListener { v, hh, mm ->
                        if (hh < 10) {
                        }

                        // Zeitwerte auf 2-Stellige Anzeige umschalten
                        val std = helper.modifyMinuteHourDayMonth(hh)
                        val minute = helper.modifyMinuteHourDayMonth(mm)
                        val dat = "$std:$minute"

                        mBinding.etNewTourTourStandzeitKunde
                            .setText(
                                dat,
                                TextView.BufferType.EDITABLE
                            );
                    }, hh, mm, true
                )
                dpd.show()
            }
            R.id.fab_save_new_tour -> {
                // lokale Variablen zum Speichern erstellen
            val tourNummer = mBinding.etNewTourTourNummer.text.toString().trim { it <= ' ' }
            val tourDatum = mBinding.etNewTourTourDatum.text.toString().trim { it <= ' ' }
            val tourDauer = mBinding.etNewTourTourDauer.text.toString().trim { it <= ' ' }
            val tourDepotZeitVt =
                mBinding.etNewTourTourDepotzeitVt.text.toString().trim { it <= ' ' }
            val tourDepotZeitNt =
                mBinding.etNewTourTourDepotzeitNt.text.toString().trim { it <= ' ' }
            val tourStandZeitKunde =
                mBinding.etNewTourTourStandzeitKunde.text.toString().trim { it <= ' ' }
            val tourFahrtZeit = mBinding.etNewTourTourFahrtzeit.text.toString().trim { it <= ' ' }
//
//            // TextFelder prüfen, ob ausgefüllt, sonst Toast

                when {
                    TextUtils.isEmpty(tourNummer) -> {
                        Toast.makeText(
                            this,
                            "Bitte geben Sie die 6- stellige Tournummer ein!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        mBinding.etNewTourTourNummer.requestFocus()
                    }
                    TextUtils.isEmpty(tourDatum) -> {
                        Toast.makeText(
                            this,
                            "Bitte geben Sie ein gültiges Datum ein!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    TextUtils.isEmpty(tourDauer) -> {
                        Toast.makeText(
                            this,
                            "Bitte geben Sie die Dauer der Tour an!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    else -> {
                        val tour: Tour = Tour(
                            0,
                            tourNummer,
                            tourDatum,
                            "",
                            tourDauer,
                            tourDepotZeitVt,
                            tourDepotZeitNt,
                            "",
                            "98",
                            "0056",
                            "269",
                            "269",
                            0,
                            0,
                            0,
                            0,
                            "",
                            "",
                            0,
                            0
                        )
                        tourenViewModel.insertTour(tour)
                        //Toast.makeText(this,"Tour ${tour.tourNummer} gespeichert").show()
                        Log.e("Tour speichern:", tour.toString())
//                        intent = Intent(this,TourenActivity::class.java)
//                        startActivity(intent)
                        finish()
                    }
                }
            }



            }

    }


}