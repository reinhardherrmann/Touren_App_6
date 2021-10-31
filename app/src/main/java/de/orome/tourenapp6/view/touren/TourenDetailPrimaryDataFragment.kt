package de.orome.tourenapp6.view.touren

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.FragmentTourenDetailPrimaryDataBinding

class TourenDetailPrimaryDataFragment: Fragment() {

    private lateinit var mBinding: FragmentTourenDetailPrimaryDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTourenDetailPrimaryDataBinding.inflate(layoutInflater)

        return mBinding.root
    }
}