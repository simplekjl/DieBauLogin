package com.example.diebaulogin.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diebaulogin.ui.forgotpassword.ForgotPasswordScreen
import com.example.diebaulogin.ui.login.LoginScreen
import com.example.diebaulogin.ui.signup.SignUpScreen

@ExperimentalMaterial3Api
@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.ForgotPassword.route) {
            ForgotPasswordScreen()
        }
        composable(route = Screen.Signup.route) {
            SignUpScreen()
        }
    }
}