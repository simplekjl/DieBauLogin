package com.example.diebaulogin.domain.usecase

import com.example.diebaulogin.domain.repository.ServerRepository
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class ForgotPasswordUseCaseTest {

    private val serverRepository: ServerRepository = mockk(relaxed = true)
    private lateinit var forgotPasswordUseCase: ForgotPasswordUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        forgotPasswordUseCase = ForgotPasswordUseCase(serverRepository)
    }

    @Test
    fun forgotPasswordCall() {
        runTest {
            forgotPasswordUseCase.invoke("email").collectLatest {
                assertEquals(it.data, true)
            }
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}