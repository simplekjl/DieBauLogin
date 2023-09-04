package com.example.diebaulogin.ui.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoginEnabled: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = true,
)
