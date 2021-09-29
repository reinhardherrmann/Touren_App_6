package de.orome.tourenapp6.view.touren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.orome.tourenapp6.R


class TourenHomeFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var btnTourDetails: Button
    private lateinit var fabNewTour: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       rootView = inflater.inflate(R.layout.fragment_touren_home, container, false)

        val navControler = findNavController(this)

        btnTourDetails = rootView.findViewById(R.id.btn_tour_details)
        fabNewTour = rootView.findViewById(R.id.fab_new_tour)

        btnTourDetails.setOnClickListener {
            navControler.navigate(R.id.action_tourenHomeFragment_to_tourenDetailFragment)
        }

        fabNewTour.setOnClickListener {
            navControler.navigate(R.id.action_tourenHomeFragment_to_newTourFragment)
        }

        return rootView

    }

}