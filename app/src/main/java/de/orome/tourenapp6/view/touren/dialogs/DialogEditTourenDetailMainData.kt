package de.orome.tourenapp6.view.touren.dialogs

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import de.orome.tourenapp6.R
import de.orome.tourenapp6.databinding.DialogEditTourenDetailMainDataBinding
import de.orome.tourenapp6.model.database.entities.Tour
import de.orome.tourenapp6.viewmodel.TourenDetailViewModel
import de.orome.tourenapp6.viewmodel.TourenDetailViewModelFactory
import de.orome.tourenapp6.viewmodel.TourenViewModel
import de.orome.tourenapp6.viewmodel.tourenViewModelFactory

class DialogEditTourenDetailMainData(var tour: Tour? = null): DialogFragment() {

    private lateinit var rootView: View

    // buttons
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button

    // Edittexts
    private lateinit var etTourNummer: EditText
    private lateinit var etTourDatum: EditText
    private lateinit var etTourDauer: EditText
    private lateinit var etTourStartZeit: EditText
    private lateinit var etTourEndeZeit: EditText

    // viewModel
    private lateinit var viewModel: TourenDetailViewModel

    // Daten
    private var mtour: Tour? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.dialog_edit_touren_detail_main_data,container,false)

        initEditTexts()
        initButtons()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity(),TourenDetailViewModelFactory(requireActivity().application)).get(TourenDetailViewModel::class.java)
        //mtour = tour
        if (tour != null){
            etTourNummer.setText(tour?.tourNummer?.toEditable())
            etTourDatum.setText(tour?.tourDatum?.toEditable())
            etTourDauer.setText(tour?.tourDauer?.toEditable())
            etTourStartZeit.setText(tour?.tourStartZeit?.toEditable())
            etTourEndeZeit.setText(tour?.tourEndeZeit?.toEditable())
        }
    }

    private fun initButtons(){
        btnSave = rootView.findViewById(R.id.btn_dialog_edit_touren_detail_main_data_save)
        btnCancel = rootView.findViewById(R.id.btn_dialog_edit_touren_detail_main_data_cancel)

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnSave.setOnClickListener { saveData(tour!!) }
    }

    private fun initEditTexts(){
        etTourNummer = rootView.findViewById(R.id.et_dialog_edit_touren_detail_tour_nummer)
        etTourDatum = rootView.findViewById(R.id.et_dialog_edit_touren_detail_tour_datum)
        etTourDauer = rootView.findViewById(R.id.et_dialog_edit_touren_detail_tour_dauer)
        etTourStartZeit = rootView.findViewById(R.id.et_dialog_edit_touren_detail_tour_startzeit)
        etTourEndeZeit = rootView.findViewById(R.id.et_dialog_edit_touren_detail_tour_endezeit)
    }

    private fun saveData(tour:Tour){
        tour?.tourNummer = etTourNummer.text.toString().trim()
        tour?.tourDatum = etTourDatum.text.toString().trim()
        tour?.tourDauer = etTourDauer.text.toString().trim()
        tour?.tourStartZeit = etTourStartZeit.text.toString().trim()
        tour?.tourEndeZeit = etTourEndeZeit.text.toString().trim()
        tour?.tourNummer.let {
            viewModel.updateTour(tour)
        }
        Toast.makeText(requireContext(),"Tour ${tour.tourNummer} gespeichert", Toast.LENGTH_SHORT).show()
        dismiss()
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}