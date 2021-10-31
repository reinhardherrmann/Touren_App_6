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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import de.orome.tourenapp6.R
import de.orome.tourenapp6.adapter.TourenDetailViewPagerStateAdapter
import de.orome.tourenapp6.databinding.FragmentTourenDetailBinding
import de.orome.tourenapp6.helper.Constants
import de.orome.tourenapp6.viewmodel.TourenViewModel


class TourenDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenDetailBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: TourenDetailViewPagerStateAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourenDetailBinding.inflate(layoutInflater)


        initViewPager2()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : TourenDetailFragmentArgs by navArgs()
        Log.e("Tourennummer:","${args.tourenDetails.tourNummer}")
    }

    private fun initViewPager2(){
        viewPager = mBinding.tourenDetailViewpager2
        adapter = TourenDetailViewPagerStateAdapter(parentFragmentManager,lifecycle)
        viewPager.adapter = adapter

        // TabLayout
        tabLayout = mBinding.tourenDetailTabLayout
        val tabNames = Constants.gettourDetailTabNames()
        TabLayoutMediator(tabLayout,viewPager){tab, pos ->
            tab.text = tabNames[pos]
        }.attach()
    }

}