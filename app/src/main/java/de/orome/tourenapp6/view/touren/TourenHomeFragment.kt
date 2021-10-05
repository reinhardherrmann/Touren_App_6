package de.orome.tourenapp6.view.touren

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.orome.tourenapp6.R
import de.orome.tourenapp6.application.TourenApplication
import de.orome.tourenapp6.databinding.FragmentTourenHomeBinding
import de.orome.tourenapp6.viewmodel.TourenViewModel
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory


class TourenHomeFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenHomeBinding
    private val mtourenViewModel: TourenViewModel by viewModels{
        tourenViewModelFactory((requireActivity().application as TourenApplication).repository)
    }


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mtourenViewModel.top10TourenList.observe(viewLifecycleOwner){
            touren ->
            touren.let {
                for (item in it){
                    Log.i("Tour:", "Tour ${item.tourNummer}, ${item.tourDatum}")
                }
            }
        }
    }
}