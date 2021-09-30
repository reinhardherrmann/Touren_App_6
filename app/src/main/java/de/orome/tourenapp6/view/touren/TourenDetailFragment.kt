package de.orome.tourenapp6.view.touren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.orome.tourenapp6.R
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


}