package com.example.diebaulogin.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.domain.usecase.SignupUseCase
import com.example.diebaulogin.navigation.NavTarget
import com.example.diebaulogin.navigation.Navigator
import com.example.diebaulogin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val navigator: Navigator,
    private val signupUseCase: SignupUseCase
) : ViewModel() {
    private val _signupState = MutableStateFlow(SignupState())
    val signupState = _signupState.asStateFlow()

    fun signUp() {
        //_signupState.value = signupStateStateFlow.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = signupUseCase(
                Signup(
                    name = signupState.value.name,
                    username = signupState.value.username,
                    password = signupState.value.password
                )
            )
            result.collect {
                when (it) {
                    is Resource.Error -> {
                    }

                    is Resource.Success -> {
                        navigator.navigateTo(NavTarget.StartPage)
                    }

                    is Resource.Loading -> {
                    }
                }
            }
        }
    }


    fun setName(name: String) {
        _signupState.value = _signupState.value.copy(name = name)
        isFormValid()
    }

    fun setUsername(username: String) {
        _signupState.value = signupState.value.copy(username = username)
        isFormValid()
    }

    fun setPassword(password: String) {
        _signupState.value = signupState.value.copy(password = password)
        isFormValid()
    }

    fun setConfirmedPassword(password2: String) {
        _signupState.value = signupState.value.copy(confirmPassword = password2)
        isFormValid()
    }

    fun backToLogin() {
        navigator.navigateTo(NavTarget.Login)
    }

    private fun isFormValid() {
        _signupState.value = with(_signupState.value) {
            val isNameCorrect = name.length > 4
            val isUserNameCorrect = username.length > 4
            val isPasswordCorrect = password.length > 8
            val arePasswordMatching = password == confirmPassword
            this.copy(
                isSignupButtonEnabled = isNameCorrect && isUserNameCorrect && isPasswordCorrect && arePasswordMatching
            )
        }
    }
}