package com.example.diebaulogin.ui.login

import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.usecase.LoginUseCase
import com.example.diebaulogin.navigation.NavTarget
import com.example.diebaulogin.navigation.Navigator
import com.example.diebaulogin.util.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import utils.MainCoroutineRule

@OptIn(ExperimentalCoroutinesApi::class)
internal class LoginViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val navigator: Navigator = mockk(relaxed = true)
    private val loginUseCase: LoginUseCase = mockk(relaxed = true)

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginViewModel = LoginViewModel(navigator, loginUseCase)
    }

    @Test
    fun `when user clicks login then login usecase returns success then navigate to StartPage`() {
        coEvery { loginUseCase.invoke(Login("username", "pass")) } returns
                flowOf(Resource.Success(true))

        runTest {
            loginViewModel.logIn("username", "pass")
            verify(exactly = 1) { navigator.navigateTo(NavTarget.StartPage) }
        }
    }
    // more cases can be covered in future development

    @After
    fun tearDown() {
        unmockkAll()
    }
}