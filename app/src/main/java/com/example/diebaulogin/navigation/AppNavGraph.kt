package com.example.diebaulogin.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diebaulogin.ui.forgotpassword.ForgotPasswordScreen
import com.example.diebaulogin.ui.home.HomeScreen
import com.example.diebaulogin.ui.login.LoginScreen
import com.example.diebaulogin.ui.login.LoginViewModel
import com.example.diebaulogin.ui.signup.SignUpScreen
import com.example.diebaulogin.ui.signup.SignupViewModel

@ExperimentalMaterial3Api
@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = NavTarget.Login.route) {
        composable(route = NavTarget.Login.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                state = viewModel.loginState.collectAsState().value,
                onLoginCLicked = { u, r -> viewModel.logIn(u, r) },
                onUsernameChanged = viewModel::validateUsername,
                onPasswordChanged = viewModel::validatePassword,
                onRecoveryPasswordClicked = viewModel::recoverPassword,
                onSignUpClicked = viewModel::onSignupClicked
            )
        }
        composable(route = NavTarget.ForgotPassword.route) {
            ForgotPasswordScreen()
        }
        composable(route = NavTarget.Signup.route) {
            val viewModel = hiltViewModel<SignupViewModel>()
            SignUpScreen(
                state = viewModel.signupState.collectAsState().value,
                onSignupClicked = viewModel::signUp,
                onNameChanged = viewModel::setName,
                onUsernameChanged = viewModel::setUsername,
                onPasswordChanged = viewModel::setPassword,
                onConfirmedPassword = viewModel::setConfirmedPassword,
                onBackToLoginClicked = viewModel::backToLogin
            )
        }
        composable(route = NavTarget.StartPage.route) {
            HomeScreen()
        }
    }
}