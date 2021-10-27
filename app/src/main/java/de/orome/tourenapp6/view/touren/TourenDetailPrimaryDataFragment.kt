package de.orome.tourenapp6.view.touren

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.orome.tourenapp6.R

class TourenDetailPrimaryDataFragment: Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_touren_detail_primary_data,container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}