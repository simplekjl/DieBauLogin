package com.example.diebaulogin.ui.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val error: String? = null,
    val isLoading: Boolean = false,
    val isLoginButtonEnabled: Boolean = false,
)
