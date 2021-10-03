package de.orome.tourenapp6.view.touren

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import de.orome.tourenapp6.application.TourenApplication
import de.orome.tourenapp6.databinding.FragmentNewTourBinding
import de.orome.tourenapp6.helper.Helper
import de.orome.tourenapp6.model.database.daos.TourDao
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.model.repository.TourenRepository
import de.orome.tourenapp6.viewmodel.TourenViewModel
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory
import java.util.*


class NewTourFragment : Fragment() {

    private lateinit var mBinding: FragmentNewTourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val helper = Helper()
        var dat: String = " "
        var std: String = ""
        var minute: String = ""
        var tag: String = ""
        var monat: String = ""

        // Inflate the layout for this fragment
        mBinding = FragmentNewTourBinding.inflate(layoutInflater)

       //val tourDao:TourDao = TourDao()
        //val tourenViewModelFactory = tourenViewModelFactory(repository = TourenRepository(tourDao))
        val tourenViewModel = ViewModelProvider(requireActivity(),tourenViewModelFactory(
            TourenApplication().repository)).get(TourenViewModel::class.java)


        // ----------- onClickListener für Datums und Zeit-Dialoge

//        mBinding.etNewTourTourDatum.setOnClickListener {
//            val c = Calendar.getInstance()
//            val year = c.get(Calendar.YEAR)
//            val month = c.get(Calendar.MONTH)
//            val day = c.get(Calendar.DAY_OF_MONTH)
//
//            val dpd = DatePickerDialog(
//                requireContext(), DatePickerDialog.OnDateSetListener { v, year, month, day ->
//
//                    tag = helper.modifyMinuteHourDayMonth(day)
//                    monat = helper.modifyMinuteHourDayMonth(month + 1)
//
//                    dat = tag + "." + monat + "." + year.toString()
//                    mBinding.etNewTourTourDatum.setText(
//                        dat,
//                        TextView.BufferType.EDITABLE
//                    );
//                }, year, month, day
//            )
//            dpd.show()
//        }
//
//        mBinding.etNewTourTourDauer.setOnClickListener {
//            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
//            val c = Calendar.getInstance()
//            val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
//            val mm = 25 //c.get(Calendar.MINUTE)
//
//            val dpd = TimePickerDialog(
//                requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
//                    if (hh < 10) {
//                    }
//
//                    // Zeitwerte auf 2-Stellige Anzeige umschalten
//                    std = helper.modifyMinuteHourDayMonth(hh)
//                    minute = helper.modifyMinuteHourDayMonth(mm)
//                    dat = "$std:$minute"
//
//                    mBinding.etNewTourTourDauer
//                        .setText(
//                            dat,
//                            TextView.BufferType.EDITABLE
//                        );
//                }, hh, mm, true
//            )
//            dpd.show()
//        }
//
//        mBinding.etNewTourTourDepotzeitVt.setOnClickListener {
//            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
//            val c = Calendar.getInstance()
//            val hh = 1 //c.get(Calendar.HOUR_OF_DAY)
//            val mm = 25 //c.get(Calendar.MINUTE)
//
//            val dpd = TimePickerDialog(
//                requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
//                    if (hh < 10) {
//                    }
//
//                    // Zeitwerte auf 2-Stellige Anzeige umschalten
//                    std = helper.modifyMinuteHourDayMonth(hh)
//                    minute = helper.modifyMinuteHourDayMonth(mm)
//                    dat = "$std:$minute"
//
//                    mBinding.etNewTourTourDepotzeitVt
//                        .setText(
//                            dat,
//                            TextView.BufferType.EDITABLE
//                        );
//                }, hh, mm, true
//            )
//            dpd.show()
//        }
//
//        mBinding.etNewTourTourDepotzeitNt.setOnClickListener {
//            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
//            val c = Calendar.getInstance()
//            val hh = 0 //c.get(Calendar.HOUR_OF_DAY)
//            val mm = 25 //c.get(Calendar.MINUTE)
//
//            val dpd = TimePickerDialog(
//                requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
//                    if (hh < 10) {
//                    }
//
//                    // Zeitwerte auf 2-Stellige Anzeige umschalten
//                    std = helper.modifyMinuteHourDayMonth(hh)
//                    minute = helper.modifyMinuteHourDayMonth(mm)
//                    dat = "$std:$minute"
//
//                    mBinding.etNewTourTourDepotzeitNt
//                        .setText(
//                            dat,
//                            TextView.BufferType.EDITABLE
//                        );
//                }, hh, mm, true
//            )
//            dpd.show()
//        }
//
//        mBinding.etNewTourTourStandzeitKunde.setOnClickListener {
//            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
//            val c = Calendar.getInstance()
//            val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
//            val mm = 25 //c.get(Calendar.MINUTE)
//
//            val dpd = TimePickerDialog(
//                requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
//                    if (hh < 10) {
//                    }
//
//                    // Zeitwerte auf 2-Stellige Anzeige umschalten
//                    std = helper.modifyMinuteHourDayMonth(hh)
//                    minute = helper.modifyMinuteHourDayMonth(mm)
//                    dat = "$std:$minute"
//
//                    mBinding.etNewTourTourStandzeitKunde
//                        .setText(
//                            dat,
//                            TextView.BufferType.EDITABLE
//                        );
//                }, hh, mm, true
//            )
//            dpd.show()
//        }
//
//        mBinding.etNewTourTourFahrtzeit.setOnClickListener {
//            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
//            val c = Calendar.getInstance()
//            val hh = 3 //c.get(Calendar.HOUR_OF_DAY)
//            val mm = 25 //c.get(Calendar.MINUTE)
//
//            val dpd = TimePickerDialog(
//                requireContext(), TimePickerDialog.OnTimeSetListener { v, hh, mm ->
//                    if (hh < 10) {
//                    }
//
//                    // Zeitwerte auf 2-Stellige Anzeige umschalten
//                    std = helper.modifyMinuteHourDayMonth(hh)
//                    minute = helper.modifyMinuteHourDayMonth(mm)
//                    dat = "$std:$minute"
//
//                    mBinding.etNewTourTourFahrtzeit
//                        .setText(
//                            dat,
//                            TextView.BufferType.EDITABLE
//                        );
//                }, hh, mm, true
//            )
//            dpd.show()
//        }
//
//        mBinding.fabSaveNewTour.setOnClickListener {
//            // lokale Variablen zum Speichern erstellen
//            val tourNummer = mBinding.etNewTourTourNummer.text.toString().trim { it <= ' ' }
//            val tourDatum = mBinding.etNewTourTourDatum.text.toString().trim { it <= ' ' }
//            val tourDauer = mBinding.etNewTourTourDauer.text.toString().trim { it <= ' ' }
//            val tourDepotZeitVt =
//                mBinding.etNewTourTourDepotzeitVt.text.toString().trim { it <= ' ' }
//            val tourDepotZeitNt =
//                mBinding.etNewTourTourDepotzeitNt.text.toString().trim { it <= ' ' }
//            val tourStandZeitKunde =
//                mBinding.etNewTourTourStandzeitKunde.text.toString().trim { it <= ' ' }
//            val tourFahrtZeit = mBinding.etNewTourTourFahrtzeit.text.toString().trim { it <= ' ' }
//
//            // TextFelder prüfen, ob ausgefüllt, sonst Toast
//            when {
//                TextUtils.isEmpty(tourNummer) -> {
//                    Toast.makeText(
//                        requireActivity(),
//                        "Bitte geben Sie die 6- stellige Tournummer ein!",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                    mBinding.etNewTourTourNummer.requestFocus()
//                }
//                TextUtils.isEmpty(tourDatum) -> {
//                    Toast.makeText(
//                        requireActivity(),
//                        "Bitte geben Sie ein gültiges Datum ein!",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                }
//                TextUtils.isEmpty(tourDauer) -> {
//                    Toast.makeText(
//                        requireActivity(),
//                        "Bitte geben Sie die Dauer der Tour an!",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                }
//                else -> {
//                    val tour: Tour = Tour(
//                        0,
//                        tourNummer,
//                        tourDatum,
//                        "",
//                        tourDauer,
//                        tourDepotZeitVt,
//                        tourDepotZeitNt,
//                        "",
//                        "98",
//                        "0056",
//                        "269",
//                        "269",
//                        0,
//                        0,
//                        0,
//                        0,
//                        "",
//                        "",
//                        0,
//                        0
//                    )
//                    tourenViewModel.insertTour(tour)
//                    //Toast.makeText(requireActivity(),"Tour ${tour.tourNummer} gespeichert").show()
//                    Log.e("Tour speichern:", tour.toString())
//
//                }
//            }
//
//        }
//        // Wochentag ermitteln


        return mBinding.root
    }

}