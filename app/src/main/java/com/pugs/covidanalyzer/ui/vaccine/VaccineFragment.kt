package com.pugs.covidanalyzer.ui.vaccine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pugs.covidanalyzer.R

class VaccineFragment : Fragment(R.layout.fragment_vaccine) {

    companion object {
        //fun newInstance() = VaccineFragment()
    }

    //private lateinit var viewModel: VaccineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vaccine, container, false)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VaccineViewModel::class.java)
        // TODO: Use the ViewModel
    }
*/
}