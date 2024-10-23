package com.example.mobilecashapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mobilecashapp.presentation.events.HomeEvent
import com.example.mobilecashapp.presentation.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class HomeViewModel :ViewModel(){
    val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    fun onEvent(event:HomeEvent){
        when(event){
            HomeEvent.onHistoryButtonClicked -> {
                _homeUiState.update { it.copy(isWalletCLicked = false) }
                _homeUiState.update { it.copy(isHistoryCLicked = true) }
            }
            HomeEvent.onWalletButtonClicked -> {
                _homeUiState.update { it.copy(isWalletCLicked = true) }
                _homeUiState.update { it.copy(isHistoryCLicked = false) }
            }

            HomeEvent.onSeeMoreButtonCLicked ->{
                _homeUiState.update { it.copy(isSeeMoreClicked = true) }
            }
        }
    }

}
