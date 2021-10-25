package de.orome.tourenapp6.view.touren

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import de.orome.tourenapp6.databinding.FragmentTourenDetailBinding


class TourenDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourenDetailBinding.inflate(layoutInflater)


        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : TourenDetailFragmentArgs by navArgs()
        Log.e("Tourennummer:","${args.tourenDetails.tourNummer}")
    }


}