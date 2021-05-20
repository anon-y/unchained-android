package com.github.livingwithhippos.unchained.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.livingwithhippos.unchained.base.UnchainedFragment
import com.github.livingwithhippos.unchained.databinding.FragmentSearchBinding
import com.github.livingwithhippos.unchained.search.viewmodel.SearchViewModel
import com.github.livingwithhippos.unchained.utilities.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : UnchainedFragment() {

    private var _binding: FragmentSearchBinding? = null
    val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    private fun setup() {

        binding.button.setOnClickListener {
            viewModel.fetchAppDetails()
        }

        viewModel.appDetailsLiveData.observe(viewLifecycleOwner, EventObserver { details ->
            details?.let {
                val text = (it.name + " " + it.appData.description)
                binding.text.text = text
            }
        })
    }
}