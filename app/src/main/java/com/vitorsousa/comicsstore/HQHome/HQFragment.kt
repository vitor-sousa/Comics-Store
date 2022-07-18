package com.vitorsousa.comicsstore.HQHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.vitorsousa.comicsstore.HQViewModel
import com.vitorsousa.comicsstore.R
import com.vitorsousa.comicsstore.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class HQFragment : Fragment(), HQItemListener {

    private val viewModel by navGraphViewModels<HQViewModel>(R.id.hq_graph){defaultViewModelProviderFactory}
    private lateinit var binding: FragmentItemListBinding
    private lateinit var adapter: MyhqRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(layoutInflater)

        val view = binding.root as RecyclerView
        adapter = MyhqRecyclerViewAdapter(this@HQFragment)

        view.apply {
            this.adapter = this@HQFragment.adapter
            this.layoutManager = LinearLayoutManager(context)
        }

        initObservers()
        return view
    }


    private fun initObservers() {
        viewModel.hqListLiveData.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
        viewModel.navigationToDetailsLive.observe(viewLifecycleOwner) {
            val action = HQFragmentDirections.actionHQFragmentToHQDetailsFragment()
            findNavController().navigate(action)
        }
    }


    override fun onItemSelected(position: Int) {
        viewModel.onHQSelected(position)
        //findNavController().navigate(R.id.action_HQFragment_to_HQDetailsFragment)
    }
}