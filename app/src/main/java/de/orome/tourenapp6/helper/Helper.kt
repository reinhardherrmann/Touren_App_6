package de.orome.tourenapp6.helper

import java.util.*

class Helper {

    fun returnActualDate(): String{
        val c = Calendar.getInstance()
        val year= c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datum: String = day.toString() + "." + month.toString() + "." + year.toString()

        return datum
    }
}