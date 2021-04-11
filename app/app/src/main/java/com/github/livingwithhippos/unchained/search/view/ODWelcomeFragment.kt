package com.github.livingwithhippos.unchained.search.view

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.livingwithhippos.unchained.R
import com.github.livingwithhippos.unchained.databinding.FragmentOdWelcomeBinding
import com.github.livingwithhippos.unchained.utilities.ORION_HOME
import com.github.livingwithhippos.unchained.utilities.extension.getClipboardText
import com.github.livingwithhippos.unchained.utilities.extension.isMagnet
import com.github.livingwithhippos.unchained.utilities.extension.isWebUrl
import com.github.livingwithhippos.unchained.utilities.extension.makeSpannableLink
import com.github.livingwithhippos.unchained.utilities.extension.openExternalWebPage


/**
 * A simple [Fragment] subclass.
 */
class ODWelcomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOdWelcomeBinding.inflate(inflater, container, false)

        binding.bOpenLink.setOnClickListener {
            openExternalWebPage(ORION_HOME)
        }

        binding.bPasteApiKey.setOnClickListener {
            binding.tiPrivateCode.setText(getClipboardText(), TextView.BufferType.EDITABLE)
        }

        // todo: controlla se c'è la chiave API e fai una chiamata per controllare se è valida
        // metti un overlay sopra a questo fragment e poi toglilo se la chiave non c'è o non è valida
        // vai automaticamente all altro fragment se invece è valida
        return binding.root
    }
}