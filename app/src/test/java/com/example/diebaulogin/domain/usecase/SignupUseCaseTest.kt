package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.domain.repository.ServerRepository
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class SignupUseCaseTest {

    private val serverRepository: ServerRepository = mockk(relaxed = true)
    private lateinit var loginUseCase: SignupUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginUseCase = SignupUseCase(serverRepository)
    }

    @Test
    fun signUp() {
        runTest {
            loginUseCase.invoke(
                Signup(
                    "Jose Crisostomo",
                    "simplekjl",
                    "pass"
                )
            )
                .collectLatest {
                    Assert.assertEquals(it.data, true)
                }
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}