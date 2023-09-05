package com.example.diebaulogin.ui.signup

data class SignupState(
    val name: String = "",
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String? = null,
    val isLoading: Boolean = false,
    val isSignupButtonEnabled: Boolean = false,
)
