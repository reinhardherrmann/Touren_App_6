package de.orome.tourenapp6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.orome.tourenapp6.databinding.ItemTourenListeBinding
import de.orome.tourenapp6.model.database.entities.Tour

class TourenListAdapter(private val fragment: Fragment): RecyclerView.Adapter<TourenListAdapter.ViewHolder>() {

    private var touren: List<Tour> = listOf() // als leere Liste initialisieren

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding: ItemTourenListeBinding = ItemTourenListeBinding.inflate(LayoutInflater.from(
            fragment.context),
            parent,
            false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tour = touren[position]
        holder.tvTourNummer.text = tour.tourNummer
        holder.tvTourDatum.text = tour.tourDatum
        holder.tvTourAnzStopps.text = tour.tourStopps.toString()
        // TODO Status muss im Model implementiert und dann ausgelesen werden
        holder.tvTourStatus.text = tour.tourStatus
    }

    override fun getItemCount(): Int {
        return touren.size
    }


    fun tourenListe(list: List<Tour>){
        touren = list
        notifyDataSetChanged()
    }




    class ViewHolder(view: ItemTourenListeBinding): RecyclerView.ViewHolder(view.root) {
        // Holds the TextViews
        val tvTourDatum = view.tourItemTvTourDatum
        val tvTourNummer = view.tourItemTvTourNummer
        val tvTourAnzStopps = view.tourItemTvAnzStopps
        val tvTourStatus = view.tourItemTvStatus
    }


}