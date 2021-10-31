package de.orome.tourenapp6.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import de.orome.tourenapp6.helper.Constants
import de.orome.tourenapp6.view.touren.TourenDetailPrimaryDataFragment
import de.orome.tourenapp6.view.touren.TourenDetailStartStopFragment
import de.orome.tourenapp6.view.touren.TourenDetailStoppsListFragment

class TourenDetailViewPagerStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments: ArrayList<Fragment> = Constants.getTourDetailsFragmentList()


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}
