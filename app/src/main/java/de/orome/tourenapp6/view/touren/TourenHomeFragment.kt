package de.orome.tourenapp6.view.touren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.FragmentTourenHomeBinding


class TourenHomeFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourenHomeBinding.inflate(layoutInflater)
        val view = mBinding.root

        val navControler = findNavController(this)

        mBinding.btnTourDetails.setOnClickListener {
            navControler.navigate(R.id.action_tourenHomeFragment_to_tourenDetailFragment)
        }

        mBinding.fabNewTour.setOnClickListener {
            navControler.navigate(R.id.action_tourenHomeFragment_to_newTourActivity)
        }

        return view

    }

}