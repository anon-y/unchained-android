package com.github.livingwithhippos.unchained.search.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.livingwithhippos.unchained.R
import com.github.livingwithhippos.unchained.databinding.FragmentOdWelcomeBinding
import com.github.livingwithhippos.unchained.search.viewmodel.ODWelcomeViewModel
import com.github.livingwithhippos.unchained.utilities.ORION_HOME
import com.github.livingwithhippos.unchained.utilities.extension.getClipboardText
import com.github.livingwithhippos.unchained.utilities.extension.openExternalWebPage
import com.github.livingwithhippos.unchained.utilities.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class ODWelcomeFragment : Fragment() {

    private var _binding: FragmentOdWelcomeBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var preferences: SharedPreferences

    private val viewModel: ODWelcomeViewModel by viewModels()

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOdWelcomeBinding.inflate(inflater, container, false)

        setup()
        
        return binding.root
    }

    private fun setup() {

        if (viewModel.checkCurrentCredentials()) {
            val action = ODWelcomeFragmentDirections.actionSearchDestToSearchFragment()
            findNavController().navigate(action)
        } else {

            binding.bOpenLink.setOnClickListener {
                openExternalWebPage(ORION_HOME)
            }

            binding.bPasteApiKey.setOnClickListener {
                val pasteText = getClipboardText()
                binding.tiPrivateCode.setText(pasteText, TextView.BufferType.EDITABLE)
            }

            binding.bCheckKey.setOnClickListener {
                val code = binding.tiPrivateCode.text.toString()
                if (code.length > 10)
                    viewModel.checkAndSaveCredentials(code)
                else
                    context?.showToast(R.string.invalid_token)
            }

            // maybe an event is not needed, once we have the user we shouldn't come back to this screen
            viewModel.userLiveData.observe(viewLifecycleOwner) {
                // check user status?
                it.getContentIfNotHandled()?.let { user ->
                    if (user.result.status == "success") {
                        val action = ODWelcomeFragmentDirections.actionSearchDestToSearchFragment()
                        findNavController().navigate(action)
                    } else {
                        context?.showToast(R.string.invalid_token)
                    }
                }
            }

        }
    }
}