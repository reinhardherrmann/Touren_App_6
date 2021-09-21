package de.orome.tourenapp6.view.touren

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.orome.tourenapp6.R
import de.orome.tourenapp6.viewmodel.TourenViewModel

class AllTourenFragment : Fragment() {

    private lateinit var tourenViewModel: TourenViewModel

    // Kap 22.1 Anpassung
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setHasOptionsMenu(true)
    } //ende Kap 22.1

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tourenViewModel =
                ViewModelProvider(this).get(TourenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_touren, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        tourenViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    // Kap 22.1 Anpassung
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_touren,menu)
        super.onCreateOptionsMenu(menu, inflater)
    } // Ende Kap 22.1

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mnuAllTourenAddTour -> {
                startActivity(Intent(requireActivity(),AddUpdateTourActivity::class.java))
                return true
            }
        }


        return super.onOptionsItemSelected(item)
    }
    // Ende Kap 22.1

}