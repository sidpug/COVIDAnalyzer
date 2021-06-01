 package com.pugs.covidanalyzer.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pugs.covidanalyzer.R
import com.pugs.covidanalyzer.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        view?.findViewById<Button>(R.id.button_call)?.setOnClickListener {
            val number = "+911123978046"
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(number)))
        }
        /*view?.findViewById<Button>(R.id.button_sms)?.setOnClickListener {
            val mail = "+911123978046"
            startActivity(Intent(Intent.ACTION_, Uri.parse(mail)))
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}