package de.orome.tourenapp6.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_touren")
data class Tour(
    @PrimaryKey(autoGenerate = true)
    val tour_id: Int,
    @ColumnInfo(name = "tour_nummer") val tourNummer: String,
    @ColumnInfo(name = "tour_datum") val tourDatum: String,
    @ColumnInfo(name = "tour_dauer") val tourDauer: String,
    @ColumnInfo(name = "tour_depotzeit_vt") val tourDepotZeit_vt: String,
    @ColumnInfo(name = "tour_depotzeit_nt") val tourDepotZeit_nt: String,
    @ColumnInfo(name = "tour_standzeit_kunde") val tourStandzeitKunde: String,
    @ColumnInfo(name = "tour_fahrernummer") val tourFahrerNummer: String = "0056",
    @ColumnInfo(name = "tour_lagernummer_start") val tourLagerNummerStart: String = "269",
    @ColumnInfo(name = "tour_lagernummer_ende") val tourLagerNummerEnde: String = "269",
    @ColumnInfo(name = "tour_fahrzeugnummer") val tourFahrzeugNummer: String = "98",
    @ColumnInfo(name = "tour_vorgeladen") val tourVorgeladen: Int = 0,
    @ColumnInfo(name = "tour_entsorgung") val tourEntsorgung: Int = 1,
    @ColumnInfo(name = "tour_reinigung") val tourReinigung: Int = 1

)