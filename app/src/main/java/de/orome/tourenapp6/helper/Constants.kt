package de.orome.tourenapp6.helper

/**
 * This is used to define the constant values that we can use throughout the application.
 */

object Constants {

    fun tourStatus(): ArrayList<String>{
        val list = ArrayList<String>()
        list.add("unbearbeitet")
        list.add("offen")
        list.add("in Beladung")
        list.add("unterwegs")
        list.add("auf Rückfahrt")
        list.add("in Entsorgung")
        list.add("abgeschlossen")
        return list
    }

    fun lkwMarken(): ArrayList<String>{
        val list = ArrayList<String>()
        list.add("Mercedes")
        list.add("Volvo")
        list.add("Iveco")
        list.add("DAF")
        return list
    }
}