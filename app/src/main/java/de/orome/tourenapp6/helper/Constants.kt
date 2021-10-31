package de.orome.tourenapp6.helper

import androidx.fragment.app.Fragment
import de.orome.tourenapp6.view.touren.TourenDetailPrimaryDataFragment
import de.orome.tourenapp6.view.touren.TourenDetailStartStopFragment
import de.orome.tourenapp6.view.touren.TourenDetailStoppsListFragment

/**
 * This is used to define the constant values that we can use throughout the application.
 */

object Constants {

    fun tourStatus(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("unbearbeitet")
        list.add("in Bearbeitung")
        list.add("abgeschlossen")
        return list
    }

    fun lkwMarken(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Mercedes")
        list.add("Volvo")
        list.add("Iveco")
        list.add("DAF")
        return list
    }

    fun gettourDetailTabNames(): ArrayList<String>{
        // TODO: Namen in StringsDatei überführen
        val list = ArrayList<String>()
        list.add("Übersicht")
        list.add("Stopp\nListe")
        list.add("Einzel\nStopp")
        //list.add("Fahrzeug")
//        list.add("Beginn/Ende")
//        list.add("Entsorgung")
//        list.add("Störzeit")
//        list.add("Tankstopp")
        return list
    }

    fun getTourDetailsFragmentList(): ArrayList<Fragment>{
        val list = ArrayList<Fragment>()
        list.add(TourenDetailPrimaryDataFragment())
        list.add(TourenDetailStoppsListFragment())
        list.add(TourenDetailStartStopFragment())

        return list
    }

    fun bezirkeBerlin(): ArrayList<String> {
        var list = ArrayList<String>()
        list.add("Gesundbrunnen")
        list.add ("Hansaviertel")
        list.add ("Mitte")
        list.add ("Moabit")
        list.add ("Tiergarten")
        list.add ("Wedding")
        list.add ("Friedrichshain")
        list.add ("Kreuzberg")
        list.add ("Blankenburg")
        list.add ("Blankenfelde")
        list.add ("Buch")
        list.add ("Französisch Buchholz")
        list.add ("Heinersdorf")
        list.add ("Karow")
        list.add ("Malchow")
        list.add ("Niederschönhausen")
        list.add ("Rosenthal")
        list.add ("Pankow")
        list.add ("Prenzlauer Berg")
        list.add ("Weißensee")
        list.add ("Wilhemsruh")
        list.add ("Charlottenburg")
        list.add ("Charlottenburg-Nord")
        list.add ("Grunewald")
        list.add ("Halensee")
        list.add ("Schmargendorf")
        list.add ("Westend")
        list.add ("Wilmersdorf")
        list.add ("Falkenhagener Feld")
        list.add ("Gatow")
        list.add ("Hakenfelde")
        list.add ("Haselhorst")
        list.add ("Kladow")
        list.add ("Siemensstadt")
        list.add ("Staaken")
        list.add ("Spandau")
        list.add ("Wilhelmstadt")
        list.add ("Dahlem")
        list.add ("Lankwitz")
        list.add ("Lichterfelde")
        list.add ("Nikolassee Steglitz")
        list.add ("Wannsee")
        list.add ("Zehlendorf")
        list.add ("Friedenau")
        list.add ("Lichtenrade")
        list.add ("Mariendorf")
        list.add ("Marienfelde")
        list.add ("Schöneberg")
        list.add ("Tempelhof")
        list.add ("Britz")
        list.add ("Buckow")
        list.add ("Gropiusstadt")
        list.add ("Neukölln")
        list.add ("Rudow")
        list.add ("Adlershof")
        list.add ("Altglienicke")
        list.add ("Alt-Treptow")
        list.add ("Bohnsdorf")
        list.add ("Baumschulenweg")
        list.add ("Friedrichshagen")
        list.add ("Grünau")
        list.add ("Johannisthal")
        list.add ("Köpenick")
        list.add ("Müggelheim")
        list.add ("Niederschönweide")
        list.add ("Oberschönweide")
        list.add ("Plänterwald")
        list.add ("Rahnsdorf")
        list.add ("Schmöckwitz")
        list.add ("Biesdorf")
        list.add ("Kaulsdorf")
        list.add ("Hellersdorf")
        list.add ("Mahlsdorf")
        list.add ("Marzahn")
        list.add ("Falkenberg")
        list.add ("Fennpfuhl")
        list.add ("Friedrichsfelde")
        list.add ("Hohenschönhausen")
        list.add ("Karlshorst")
        list.add ("Lichtenberg")
        list.add ("Malchow")
        list.add ("Rummelsburg")
        list.add ("Wartenberg")

        return list
    }
}