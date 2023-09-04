package com.example.diebaulogin.navigation

sealed class UiEvent {
    data class NavigateTo(val screen: Screen) : UiEvent()
}
