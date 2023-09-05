package com.example.diebaulogin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.diebaulogin.navigation.AppNavGraph
import com.example.diebaulogin.navigation.NavTarget
import com.example.diebaulogin.navigation.Navigator
import com.example.diebaulogin.ui.theme.DieBauLoginTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DieBauLoginTheme {
                val navController = rememberNavController()
                LaunchedEffect("navigation") {
                    navigator.sharedFlow.onEach {
                        navController.navigate(it.route) {
                            if (it.route == NavTarget.Login.route)
                                popUpTo(NavTarget.Login.route) { inclusive = true }
                            else if (it.route == NavTarget.Login.route)
                                popUpTo(NavTarget.Login.route) { inclusive = true }
                        }
                    }.launchIn(this)
                }
                AppNavGraph(navController = navController)
            }
        }
    }
}