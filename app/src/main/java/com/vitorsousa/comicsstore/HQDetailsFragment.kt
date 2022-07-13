package com.vitorsousa.comicsstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.vitorsousa.comicsstore.databinding.FragmentHQDetailsBinding


class HQDetailsFragment : Fragment() {

    private val viewModel by navGraphViewModels<HQViewModel>(R.id.hq_graph){defaultViewModelProviderFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHQDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}