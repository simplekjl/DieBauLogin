package com.example.diebaulogin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.diebaulogin.ui.login.LoginScreen
import com.example.diebaulogin.ui.theme.DieBauLoginTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DieBauLoginTheme {
                LoginScreen()
            }
        }
    }
}