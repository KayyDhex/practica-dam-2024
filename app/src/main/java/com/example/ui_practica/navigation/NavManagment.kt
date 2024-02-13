package com.example.ui_practica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_practica.viewmodels.LoginViewModel
import com.example.ui_practica.views.LoginScreen

@Composable
fun NavManagment(loginViewModel: LoginViewModel) {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login" ){
        composable("Login"){
            LoginScreen(loginViewModel)
        }
//        composable("Home"){
//            HomeScreen()
//        }
    }

}