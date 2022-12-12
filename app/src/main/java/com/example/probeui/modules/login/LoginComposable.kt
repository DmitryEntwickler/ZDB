package com.example.probeui.modules.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.probeui.R
import com.example.probeui.classes.LoginState
import com.example.probeui.core.navigation.EActivityScreens
import com.example.probeui.ui.theme.*


@Composable
fun LoginComposable(mNavController: NavController) {

    var showPassword by remember { mutableStateOf(false) }
    var mPass by remember { mutableStateOf("") }
    var mPassHasError by remember { mutableStateOf(false) }

    var mEmail by remember { mutableStateOf("") }
    var mEmailHasError by remember { mutableStateOf(false) }

    val mScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = mScaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text("ZUDUBI") }
                },
                backgroundColor = GreenZDB,
                contentColor = Color.White,
                elevation = 32.dp,
            )
        }
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "Willkommen",
                style = Typography.h3
            )

            OutlinedTextField(
                value = mEmail,
                onValueChange = { mEmail = it; mEmailHasError = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .focusRequester(FocusRequester())
                    .onFocusChanged {
                        if (!it.isFocused && mEmail.isNotEmpty()) {
                            mEmailHasError = !isEmailCorrect(mEmail)
                        }
                    },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                isError = mEmailHasError,
                label = { Text("Email") },
                trailingIcon = {
                    if (mEmailHasError) Icon(
                        Icons.Default.Warning,
                        contentDescription = "Visibility"
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    errorBorderColor = Color.Red,
                    errorCursorColor = Color.Red,
                    errorTrailingIconColor = Color.Red,
                    errorLabelColor = Color.Red
                )
            )

            OutlinedTextField(
                value = mPass,
                onValueChange = { mPass = it; mPassHasError = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                isError = mPassHasError,
                label = { Text("Passwort") },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {

                    val icon = when (showPassword) {
                        true -> painterResource(id = R.drawable.outline_visibility_24)
                        false -> painterResource(id = R.drawable.outline_visibility_off_24)
                    }

                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(icon, contentDescription = "Visibility")
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    errorBorderColor = Color.Red,
                    errorCursorColor = Color.Red,
                    errorTrailingIconColor = Color.Red,
                    errorLabelColor = Color.Red,
                )
            )

            Text(
                text = "Passwort vergessen?",
                modifier = Modifier.padding(8.dp),
                style = Typography.body1,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    if (isLoginCorrect(mEmail, mPass) == LoginState.NothingOk) {mEmailHasError = true; mPassHasError = true }
                    if (isLoginCorrect(mEmail, mPass) == LoginState.EmailOkPassNotOk) {mEmailHasError = false; mPassHasError = true }
                    if (isLoginCorrect(mEmail, mPass) == LoginState.PassOkEmailNotOk) {mEmailHasError = true; mPassHasError = false }
                    if (isLoginCorrect(mEmail, mPass) == LoginState.AllOk) { mNavController.navigate(EActivityScreens.DashboardScreen.name) }
                    },
                shape = RoundedButtonShape.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenZDB,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(8.dp),
                    style = Typography.button
                )
            }
        }
    }


}

fun isEmailCorrect(email: String): Boolean {
    return (email.isNotEmpty() && email.length < 3)
}

fun isPassCorrect(pass: String): Boolean {
    return (pass.isNotEmpty() && pass.length < 3)
}

fun isLoginCorrect(email: String, pass: String): LoginState {
    var state = LoginState.NoState
    if (isEmailCorrect(email) && isPassCorrect(pass)) state = LoginState.AllOk
    if (!isEmailCorrect(email) && isPassCorrect(pass)) state = LoginState.PassOkEmailNotOk
    if (isEmailCorrect(email) && !isPassCorrect(pass)) state = LoginState.EmailOkPassNotOk
    if (!isEmailCorrect(email) && !isPassCorrect(pass)) state = LoginState.NothingOk
    return state
}
