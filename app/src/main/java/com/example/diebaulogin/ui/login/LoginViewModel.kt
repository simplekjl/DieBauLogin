package com.example.diebaulogin.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.usecase.LoginUseCase
import com.example.diebaulogin.navigation.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val event = _uiEvent.receiveAsFlow()

    init {
        checkSession()
    }

    private fun checkSession() {
        viewModelScope.launch {
            // we can have a case where the session is stored in local like a database
        }
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnPasswordChange -> event.updateState()
            is LoginEvent.OnUsernameChange -> event.updateState()
            LoginEvent.OnLoginClick -> onLoginClick()
        }
    }

    private fun LoginEvent.OnPasswordChange.updateState() {
        state = state.copy(
            password = password,
            isLoginEnabled = shouldEnableLogin(),
        )
    }

    private fun LoginEvent.OnUsernameChange.updateState() {
        state = state.copy(
            username = username,
            isLoginEnabled = shouldEnableLogin(),
        )
    }

    private fun shouldEnableLogin(): Boolean =
        state.username.isNotEmpty() && state.password.isNotEmpty()

    private fun onLoginClick() {
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            loginUseCase(
                Login(username = state.username, password = state.password)
            ).collectLatest { result ->
                when (result.data) {
                    true -> {
                        // navigate to login
                    }

                    else -> {
                        // show error
                    }
                }

            }
        }
    }
}