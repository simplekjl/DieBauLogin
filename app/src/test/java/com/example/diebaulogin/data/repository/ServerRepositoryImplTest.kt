package com.example.diebaulogin.data.repository

import com.example.diebaulogin.data.remote.ServerApi
import com.example.diebaulogin.domain.model.Login
import com.example.diebaulogin.domain.model.Signup
import com.example.diebaulogin.domain.repository.ServerRepository
import com.example.diebaulogin.util.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

internal class ServerRepositoryImplTest {

    private val serverApi: ServerApi = mockk(relaxed = true)
    private lateinit var repository: ServerRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = ServerRepositoryImpl(serverApi = serverApi)
    }

    @Test
    fun login() {
        val expected: Resource.Success<Boolean> = Resource.Success(true)
        coEvery { serverApi.someService() } returns Resource.Success(true)
        runBlocking {
            repository.login(Login("simplekjl", "pass")).collect {
                assertEquals(expected.data, actual = it.data)
            }
        }
    }

    @Test
    fun signUp() {
        val expected: Resource.Success<Boolean> = Resource.Success(true)
        coEvery { serverApi.someService() } returns Resource.Success(true)
        runTest {
            repository.signUp(Signup("Jose Crisostomo ", "simplekjl", "password"))
                .collectLatest {
                    assertEquals(expected.data, actual = it.data)
                }
        }
    }

    @Test
    fun logout() {
        val expected: Resource.Success<Boolean> = Resource.Success(true)
        coEvery { serverApi.someService() } returns Resource.Success(true)
        runTest {
            repository.logout().collectLatest {
                assertEquals(expected.data, actual = it.data)
            }
        }
    }

    @Test
    fun forgotPassword() {
        val expected: Resource.Success<Boolean> = Resource.Success(true)
        coEvery { serverApi.someService() } returns Resource.Success(true)
        runTest {
            repository.forgotPassword("jlcs.de@gmail.com").collectLatest {
                assertEquals(expected.data, actual = it.data)
            }
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}
