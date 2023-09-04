package com.example.diebaulogin.ui.login

sealed class LoginEvent {
    data class OnUsernameChange(val username: String) : LoginEvent()
    data class OnPasswordChange(val password: String) : LoginEvent()
    object OnLoginClick : LoginEvent()
}
