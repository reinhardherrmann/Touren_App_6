package de.orome.tourenapp6.view.touren

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.orome.tourenapp6.databinding.FragmentNewTourBinding
import de.orome.tourenapp6.helper.Helper
import java.util.*


class NewTourFragment : Fragment() {

    private lateinit var mBinding: FragmentNewTourBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mBinding = FragmentNewTourBinding.inflate(layoutInflater)
        val helper= Helper()
        var dat: String = " "
        var std: String = ""
        var minute: String = ""
        var tag: String =""
        var monat: String =""



        // ----------- onClickListener für Datums und Zeit-Dialoge

        mBinding.etNewTourTourDatum.setOnClickListener {
            val c = Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener{
                    v,year,month,day ->

                tag = helper.modifyMinuteHourDayMonth(day)
                monat = helper.modifyMinuteHourDayMonth(month+1)

                dat=tag + "." + monat + "." + year.toString()
                mBinding.etNewTourTourDatum.setText(dat,
                        TextView.BufferType.EDITABLE);},year,month,day
            )
            dpd.show()
        }

        mBinding.etNewTourTourDauer.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 3 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }

                // Zeitwerte auf 2-Stellige Anzeige umschalten
                std = helper.modifyMinuteHourDayMonth(hh)
                minute = helper.modifyMinuteHourDayMonth(mm)
                dat= "$std:$minute"

                mBinding.etNewTourTourDauer
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mBinding.etNewTourTourDepotzeitVt.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 1 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }

                // Zeitwerte auf 2-Stellige Anzeige umschalten
                std = helper.modifyMinuteHourDayMonth(hh)
                minute = helper.modifyMinuteHourDayMonth(mm)
                dat= "$std:$minute"

                mBinding.etNewTourTourDepotzeitVt
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mBinding.etNewTourTourDepotzeitNt.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 0 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }

                // Zeitwerte auf 2-Stellige Anzeige umschalten
                std = helper.modifyMinuteHourDayMonth(hh)
                minute = helper.modifyMinuteHourDayMonth(mm)
                dat= "$std:$minute"

                mBinding.etNewTourTourDepotzeitNt
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mBinding.etNewTourTourStandzeitKunde.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 3 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }

                // Zeitwerte auf 2-Stellige Anzeige umschalten
                std = helper.modifyMinuteHourDayMonth(hh)
                minute = helper.modifyMinuteHourDayMonth(mm)
                dat= "$std:$minute"

                mBinding.etNewTourTourStandzeitKunde
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        mBinding.etNewTourTourFahrtzeit.setOnClickListener {
            // TODO Standardzeit für Tourdauer auf 03:25 in Shared Preferences setzen
            val c = Calendar.getInstance()
            val hh= 3 //c.get(Calendar.HOUR_OF_DAY)
            val mm = 25 //c.get(Calendar.MINUTE)

            val dpd = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener{
                    v,hh,mm ->
                if (hh < 10){
                }

                // Zeitwerte auf 2-Stellige Anzeige umschalten
                std = helper.modifyMinuteHourDayMonth(hh)
                minute = helper.modifyMinuteHourDayMonth(mm)
                dat= "$std:$minute"

                mBinding.etNewTourTourFahrtzeit
                    .setText(dat,
                        TextView.BufferType.EDITABLE);},hh,mm, true
            )
            dpd.show()
        }

        return mBinding.root
    }

}