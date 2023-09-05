package com.example.diebaulogin.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.usecase.LoginUseCase
import com.example.diebaulogin.navigation.NavTarget
import com.example.diebaulogin.navigation.Navigator
import com.example.diebaulogin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    fun logIn(username: String, password: String) {
        _loginState.value = loginState.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = loginUseCase(Login(username, password))
            result.collect {
                when (it) {
                    is Resource.Error -> {
                        _loginState.value = _loginState.value.copy(
                            isLoading = false, error = "Algo salío mal, intenta de nuevo"
                        )
                    }

                    is Resource.Success -> {
                        _loginState.value = _loginState.value.copy(isLoading = false)
                        navigator.navigateTo(NavTarget.StartPage)
                    }

                    is Resource.Loading -> {
                        _loginState.value = _loginState.value.copy(isLoading = true)
                    }
                }
            }
        }
    }

    fun validateUsername(username: String) {
        _loginState.value = _loginState.value.copy(
            username = username,
            isLoginButtonEnabled = username.isNotBlank() && _loginState.value.password.isNotBlank()
        )
    }

    fun validatePassword(pass: String) {
        _loginState.value = _loginState.value.copy(
            password = pass,
            isLoginButtonEnabled = pass.isNotBlank() && _loginState.value.username.isNotBlank()
        )
    }

    fun recoverPassword() {
        navigator.navigateTo(NavTarget.ForgotPassword)
    }

    fun onSignupClicked() {
        navigator.navigateTo(NavTarget.Signup)
    }
}