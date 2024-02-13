package com.example.ui_practica.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.ui_practica.viewmodels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    val email : String by loginViewModel.email.observeAsState("")

    Scaffold (
    ){
        Column {
            Text(text = "Login")
            TextFieldEmail(email) { loginViewModel.onChange(it) }
            ButtonLogin()
        }

    }
}

@Composable
fun TextFieldEmail(email: String,function: (String)-> Unit) {
    TextField(
        value = email, onValueChange = {
            function(it)
        }
    )
}

@Composable
fun ButtonLogin(){
    Button(onClick = {}) {
        Text(text = "Entrar")
    }
}