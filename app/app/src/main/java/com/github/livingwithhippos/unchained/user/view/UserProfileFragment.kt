package com.github.livingwithhippos.unchained.user.view

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.livingwithhippos.unchained.R
import com.github.livingwithhippos.unchained.base.UnchainedFragment
import com.github.livingwithhippos.unchained.data.model.AuthenticationStatus
import com.github.livingwithhippos.unchained.databinding.FragmentUserProfileBinding
import com.github.livingwithhippos.unchained.lists.view.ListsTabFragment
import com.github.livingwithhippos.unchained.settings.view.SettingsFragment.Companion.KEY_REFERRAL_ASKED
import com.github.livingwithhippos.unchained.settings.view.SettingsFragment.Companion.KEY_REFERRAL_USE
import com.github.livingwithhippos.unchained.user.viewmodel.UserProfileViewModel
import com.github.livingwithhippos.unchained.utilities.extension.openExternalWebPage
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

const val REFERRAL_LINK = "http://real-debrid.com/?id=78841"
const val PREMIUM_LINK = "https://real-debrid.com/premium"
const val ACCOUNT_LINK = "https://real-debrid.com/account"

/**
 * A simple [UnchainedFragment] subclass.
 * Shows a user profile details.
 */
@AndroidEntryPoint
class UserProfileFragment : UnchainedFragment() {

    private val viewModel: UserProfileViewModel by viewModels()

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val userBinding = FragmentUserProfileBinding.inflate(inflater, container, false)

        viewModel.fetchUserInfo()

        viewModel.userLiveData.observe(
            viewLifecycleOwner,
            {
                if (it != null) {
                    userBinding.user = it
                    lifecycleScope.launch {
                        userBinding.privateToken = activityViewModel.isTokenPrivate()
                    }
                }
            }
        )

        userBinding.bAccount.setOnClickListener {
            // if we never asked, show a dialog
            if (!preferences.getBoolean(KEY_REFERRAL_ASKED, false)) {
                // set asked as true
                with(preferences.edit()) {
                    putBoolean(KEY_REFERRAL_ASKED, true)
                    apply()
                }

                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(getString(R.string.referral))
                    .setMessage(getString(R.string.referral_proposal))
                    .setNegativeButton(getString(R.string.decline)) { _, _ ->
                        with(preferences.edit()) {
                            putBoolean(KEY_REFERRAL_USE, false)
                            apply()
                        }
                        openExternalWebPage(ACCOUNT_LINK)
                    }
                    .setPositiveButton(getString(R.string.accept)) { _, _ ->
                        with(preferences.edit()) {
                            putBoolean(KEY_REFERRAL_USE, true)
                            apply()
                        }
                        openExternalWebPage(REFERRAL_LINK)
                    }
                    .show()
            } else {
                if (preferences.getBoolean(KEY_REFERRAL_USE, false))
                    openExternalWebPage(REFERRAL_LINK)
                else
                    openExternalWebPage(ACCOUNT_LINK)
            }
        }

        activityViewModel.newAuthenticationState.observe(
            viewLifecycleOwner,
            {
                userBinding.srLayout.isRefreshing = false
                when (it.peekContent()) {
                    AuthenticationStatus.Unauthenticated -> {
                        val action = UserProfileFragmentDirections.actionUserToAuthentication()
                        findNavController().navigate(action)
                    }
                    is AuthenticationStatus.Authenticated -> {
                        // managed by activity
                    }
                    is AuthenticationStatus.AuthenticatedNoPremium -> {
                        // managed by activity
                    }
                    is AuthenticationStatus.NeedUserAction -> {
                        // managed by activity
                    }
                    is AuthenticationStatus.RefreshToken -> {
                        // managed by activity
                    }
                }
            }
        )

        userBinding.bLogout.setOnClickListener {
            activityViewModel.logout()
        }


        userBinding.srLayout.setOnRefreshListener {
            activityViewModel.setupAuthenticationStatus()
        }

        return userBinding.root
    }
}
