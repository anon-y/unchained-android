package com.github.livingwithhippos.unchained.search.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
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
                viewModel.checkCredentials(code)
            else
                context?.showToast(R.string.invalid_token)
        }

        // metti un overlay sopra a questo fragment e poi toglilo se la chiave non c'è o non è valida
        // vai automaticamente all altro fragment se invece è valida
        return binding.root
    }
}