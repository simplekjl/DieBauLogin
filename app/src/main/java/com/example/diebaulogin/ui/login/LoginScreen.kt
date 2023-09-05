package com.example.diebaulogin.ui.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diebaulogin.R
import com.example.diebaulogin.ui.components.InputField

@Preview
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            state = LoginState(
                username = "Jose",
                password = "Denken16",
                isLoginButtonEnabled = true
            )
        )
    }
}

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginCLicked: (String, String) -> Unit = { _, _ -> },
    onUsernameChanged: (String) -> Unit = { _ -> },
    onPasswordChanged: (String) -> Unit = { _ -> },
    onRecoveryPasswordClicked: () -> Unit = {},
    onSignUpClicked: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    var username by rememberSaveable { mutableStateOf(state.username) }
    var password by rememberSaveable { mutableStateOf(state.password) }
    val loginFormVisible by remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
        // padding for navigation bar
    ) {
        Image(
            painter = painterResource(id = R.drawable.baubank_bg),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        AnimatedVisibility(
            visible = loginFormVisible,
            enter = fadeIn(
                // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                initialAlpha = 0.4f
            ),
            exit = fadeOut(
                // Overwrites the default animation with tween
                animationSpec = tween(durationMillis = 250)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scrollState)
                    .navigationBarsPadding()
                    .padding(bottom = 72.dp),
            ) {
                Image(
                    modifier = Modifier
                        .paddingFromBaseline(top = 150.dp, bottom = 70.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(270.dp),
                    painter = painterResource(R.drawable.baubap_light),
                    contentDescription = stringResource(R.string.baubap_logo),
                )
                Spacer(modifier = Modifier.fillMaxHeight(.01F))
                InputField(
                    text = username,
                    modifier = Modifier
                        .fillMaxWidth(.8F)
                        .align(Alignment.CenterHorizontally),
                    hint = R.string.login_screen_usename_hint,
                    iconDescription = R.string.login_screen_usename_hint,
                    leadingIcon = R.drawable.ic_username,
                    isSecure = false,
                    onValueChange = {
                        username = it
                        onUsernameChanged(username)
                    },
                    focusManager = focusManager
                )
                InputField(
                    modifier = Modifier
                        .fillMaxWidth(.8F)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    text = password,
                    hint = R.string.login_screen_password_hint,
                    iconDescription = R.string.login_screen_password_hint,
                    leadingIcon = R.drawable.ic_lock,
                    isSecure = true,
                    onValueChange = {
                        password = it
                        onPasswordChanged(password)
                    },
                    focusManager = focusManager,
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(.8F)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = { onLoginCLicked(username, password) },
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.primary,
                    ),
                    shape = MaterialTheme.shapes.small,
                    enabled = state.isLoginButtonEnabled,
                ) {
                    Text(
                        text = stringResource(R.string.login_screen_login_text),
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(4.dp),
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                        .clickable { onRecoveryPasswordClicked() },
                    text = stringResource(R.string.reset_password),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                )
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth(.8F)
                        .padding(top = 48.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = { onSignUpClicked() },
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.secondary,
                    ),
                    shape = MaterialTheme.shapes.extraSmall,
                    enabled = true,
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = stringResource(R.string.signup_button_title),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}