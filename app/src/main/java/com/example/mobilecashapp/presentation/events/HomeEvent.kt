package com.example.mobilecashapp.presentation.events

sealed class HomeEvent{
    data object onWalletButtonClicked: HomeEvent()
    data object onHistoryButtonClicked : HomeEvent()
    data object onSeeMoreButtonCLicked:HomeEvent()
}