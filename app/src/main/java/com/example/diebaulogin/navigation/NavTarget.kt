package com.example.diebaulogin.navigation

sealed class NavTarget(val route: String) {
    object Login : NavTarget("login_screen")
    object Signup : NavTarget("signup_screen")
    object ForgotPassword : NavTarget("forgot_password_screen")
    object StartPage : NavTarget("main_page")
}
