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
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.orome.tourenapp6.R
import de.orome.tourenapp6.adapter.TourenListAdapter
import de.orome.tourenapp6.application.TourenApplication
import de.orome.tourenapp6.databinding.FragmentTourenHomeBinding
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.viewmodel.TourenViewModel
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory


class TourenHomeFragment : Fragment() {

    private lateinit var mBinding: FragmentTourenHomeBinding
    private lateinit var navController: NavController

    private val mtourenViewModel: TourenViewModel by viewModels{
        tourenViewModelFactory((requireActivity().application as TourenApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourenHomeBinding.inflate(layoutInflater, container, false)


        navController = findNavController(this)

//        mBinding.btnTourDetails.setOnClickListener {
//            navController.navigate(R.id.action_tourenHomeFragment_to_tourenDetailFragment)
//        }

        mBinding.fabNewTour.setOnClickListener {
            navController.navigate(R.id.action_tourenHomeFragment_to_newTourActivity)
        }

        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvListTouren.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)

        val tourenListAdapter = TourenListAdapter(this@TourenHomeFragment)

        mBinding.rvListTouren.adapter = tourenListAdapter

        mtourenViewModel.top10TourenList.observe(viewLifecycleOwner){
            touren ->
            touren.let {
                if( it.isNotEmpty()){
                    mBinding.rvListTouren.visibility = View.VISIBLE
                    mBinding.tourenHomeTvNoTouren.visibility = View.GONE
                    tourenListAdapter.tourenListe(it)
                }else {
                    mBinding.rvListTouren.visibility = View.GONE
                    mBinding.tourenHomeTvNoTouren.visibility = View.VISIBLE
                }
                for (item in it){
                    Log.i("Tour:", "Tour ${item.tourNummer}, ${item.tourDatum}")

                }
            }
        }
    }

    fun gotoTourenDetails(tour: Tour){
        navController.navigate(TourenHomeFragmentDirections.actionTourenHomeFragmentToTourenDetailFragment(tour))
    }
}