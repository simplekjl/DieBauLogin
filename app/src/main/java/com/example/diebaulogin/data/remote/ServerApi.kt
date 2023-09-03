package com.example.diebaulogin.data.remote

import com.example.diebaulogin.util.Resource

interface ServerApi {
    /**
     * Mock reference to an API
     */
    fun someService() : Resource<Boolean>
}