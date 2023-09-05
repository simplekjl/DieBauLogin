package com.example.diebaulogin.ui.forgotpassword

import androidx.lifecycle.ViewModel
import com.example.diebaulogin.domain.usecase.ForgotPasswordUseCase
import com.example.diebaulogin.navigation.NavTarget
import com.example.diebaulogin.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val navigator: Navigator,
    private val forgotPasswordUseCase: ForgotPasswordUseCase
) : ViewModel() {
    // TODO implement the rest of the logic to handle the use case
    fun resetPasswordClicked() {
        navigator.navigateTo(NavTarget.Login)
    }

}
