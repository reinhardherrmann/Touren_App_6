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
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.orome.tourenapp6.databinding.FragmentTourenDetailBinding
import de.orome.tourenapp6.helper.Constants
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.view.touren.dialogs.DialogEditTourenDetailMainData
import de.orome.tourenapp6.viewmodel.TourenDetailViewModel
import de.orome.tourenapp6.viewmodel.TourenDetailViewModelFactory


class TourenDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenDetailBinding
    private lateinit var viewModel: TourenDetailViewModel
//    private var tour: Tour? = null





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
        var tour: Tour = args.tourenDetails

        viewModel = ViewModelProvider(requireActivity(),TourenDetailViewModelFactory(requireActivity().application)).get(TourenDetailViewModel::class.java)

//        Log.e("Tourennummer:","${args.tourenDetails.tourNummer}")
        val tourNummer = args.tourenDetails.tourNummer
        val lblTDetail = "Tour $tourNummer \nDetailansicht"

        fillFieldValues(args)

        mBinding.btnSaveTourPrimaryData.setOnClickListener {
            //if (mBinding.ivTDetailEditGeneralData)
            val dialog =  DialogEditTourenDetailMainData(tour)
            dialog.show(parentFragmentManager,"Tour ändern")

            // TODO hier neue Tourdaten laden
            fillFieldValues(args)
        }
    }

    fun fillFieldValues( args: TourenDetailFragmentArgs) {
        mBinding.tvTourenDetail.text = "Tour ${args.tourenDetails.tourNummer} \nDetailansicht"
        mBinding.tvTourenDetailTourDatum.setText(args.tourenDetails.tourDatum)
        mBinding.tvTourenDetailTourDauer.setText(args.tourenDetails.tourDauer)
        mBinding.tvTourenDetailTourStartZeit.setText(args.tourenDetails.tourStartZeit)
        mBinding.tvTourenDetailTourEndeZeit.setText(args.tourenDetails.tourEndeZeit)
    }


}