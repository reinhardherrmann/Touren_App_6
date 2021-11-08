package de.orome.tourenapp6.view.touren

/**
 * Fragment, von dem ausgehend die Details der Touren aufgerufen werden.
 * ViewBinding umgesetzt
 */

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.orome.tourenapp6.databinding.FragmentTourenDetailBinding
import de.orome.tourenapp6.helper.Constants


class TourenDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenDetailBinding





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourenDetailBinding.inflate(layoutInflater)

    val dummy=0
//        initViewPager2()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : TourenDetailFragmentArgs by navArgs()
        Log.e("Tourennummer:","${args.tourenDetails.tourNummer}")
        val lblTDetail = "Tour ${args.tourenDetails.tourNummer} \nDetailansicht"
        mBinding.tvTourenDetail.text = lblTDetail
        mBinding.tvTourenDetailTourDatum.setText(args.tourenDetails.tourDatum)
        mBinding.tvTourenDetailTourDauer.setText(args.tourenDetails.tourDauer)
        mBinding.tvTourenDetailTourStartZeit.setText(args.tourenDetails.tourStartZeit)

        mBinding.btnSaveTourPrimaryData.setOnClickListener {
            //if (mBinding.ivTDetailEditGeneralData)


        }
    }

//    private fun initViewPager2(){
//
//
//        // TabLayout
//
//        val tabNames = Constants.gettourDetailTabNames()
//        TabLayoutMediator(tabLayout,viewPager){tab, pos ->
//            tab.text = tabNames[pos]
//        }.attach()
//    }

}