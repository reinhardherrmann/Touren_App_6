package de.orome.tourenapp6.model.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tbl_touren")
@Parcelize
data class Tour(
    @PrimaryKey(autoGenerate = true)
    val tour_id: Int,
    @ColumnInfo(name = "tour_nummer") var tourNummer: String,
    @ColumnInfo(name = "tour_datum") var tourDatum: String,
    @ColumnInfo(name = "tour_wotag") val tourWochentag: String,
    @ColumnInfo(name = "tour_dauer") var tourDauer: String,
    @ColumnInfo(name = "tour_depotzeit_vt") val tourDepotZeit_vt: String,
    @ColumnInfo(name = "tour_depotzeit_nt") val tourDepotZeit_nt: String,
    @ColumnInfo(name = "tour_fahrtzeit") val tourFahrtZeit: String,
    @ColumnInfo(name = "tour_fahrzeugnummer") val tourFahrzeugNummer: String = "98",
    @ColumnInfo(name = "tour_fahrernummer") val tourFahrerNummer: String = "0056",
    @ColumnInfo(name = "tour_lagernummer_start") val tourLagerNummerStart: String = "269",
    @ColumnInfo(name = "tour_lagernummer_ende") val tourLagerNummerEnde: String = "269",
    @ColumnInfo(name = "tour_vorgeladen") val tourVorgeladen: Int = 0,
    @ColumnInfo(name = "tour_entsorgung") val tourEntsorgung: Int = 1,
    @ColumnInfo(name = "tour_fz_reinigung") val tourFzReinigung: Int = 1,
    @ColumnInfo(name = "tour_tankstop") val tourTankStop: Int = 1,
    @ColumnInfo(name = "tour_startzeit") var tourStartZeit: String,
    @ColumnInfo(name = "tour_endezeit") var tourEndeZeit: String,
    @ColumnInfo(name = "tour_start_km") val tourStartKm: Int,
    @ColumnInfo(name = "tour_ende_km") val tourEndeKm: Int,
    @ColumnInfo(name = "tour_stopps") val tourStopps: Int,
    @ColumnInfo(name = "tour_status") val tourStatus: String

): Parcelable