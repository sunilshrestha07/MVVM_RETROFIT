package com.example.crud.UI.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.composable
import kotlinx.serialization.Serializable


@Serializable
data object Home

@Serializable
data class Another(
    val name: String
)


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TypeSafeNavigation() {
    val navController  = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.toString()
    ) {
//        composable<Home>(){
//            HomeScreen(navController)
//        }
    }
}