package com.example.diebaulogin.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Signup : Screen("signup_screen")
    object ForgotPassword : Screen("forgot_password_screen")
}
