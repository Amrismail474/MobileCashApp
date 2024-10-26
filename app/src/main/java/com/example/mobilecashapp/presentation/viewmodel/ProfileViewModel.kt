package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.ProfileEvent
import com.example.mobilecashapp.presentation.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel(){


    private val _profile = MutableStateFlow(ProfileUiState())
    val profile = _profile.asStateFlow()


    fun OnEvent(event: ProfileEvent){
        when(event){
            ProfileEvent.OnDarkModeClicked -> {
                _profile.update {
                    it.copy(isDarkModeClicked = true)
                }
            }
            ProfileEvent.OnEditProfileClicked -> {
                _profile.update {
                    it.copy(isEditProfileClicked = true)
                }
            }
            ProfileEvent.OnHelpAndSupportClicked -> {
                _profile.update {
                    it.copy(isHelpAndSupportClicked = true)
                }
            }
            ProfileEvent.OnSettingClicked -> {
                _profile.update {
                    it.copy(isSettingClicked = true)
                }
            }
            ProfileEvent.OnSignOutCLicked ->{
                _profile.update {
                    it.copy(isSignOutCLicked = true)
                }
            }
            ProfileEvent.OnTermsAndConditionClicked -> {
                _profile.update {
                    it.copy(isTermsAndConditionClicked = true)
                }
            }
        }
    }

}