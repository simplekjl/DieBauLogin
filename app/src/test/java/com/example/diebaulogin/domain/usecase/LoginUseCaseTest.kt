package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.repository.ServerRepository
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import utils.MainCoroutineRule

@OptIn(ExperimentalCoroutinesApi::class)
internal class LoginUseCaseTest {

    private val serverRepository: ServerRepository = mockk(relaxed = true)
    private lateinit var loginUseCase: LoginUseCase

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginUseCase = LoginUseCase(serverRepository)
    }

    @Test
    fun loginUseCase_invoke() {
        runTest {
            loginUseCase.invoke(Login("simplekjl", "pass")).collectLatest {
                Assert.assertEquals(it.data, true)
            }
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}