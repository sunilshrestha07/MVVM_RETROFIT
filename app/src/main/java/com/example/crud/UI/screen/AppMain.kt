package com.example.crud.UI.screen

import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crud.UI.viewModel.DressViewModel
import  com.example.crud.R




@Composable
fun AppMain(
    dressViewModel: DressViewModel = DressViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {
                    navController.navigate("DressScreen")

                }, icon = {
                    Icon(Icons.Filled.Home, contentDescription = "Image")

                }, label = {
                    Text("Home")
                })

                NavigationBarItem(selected = true, onClick = {
                    navController.navigate("AnotherScreen")
                }, icon = {
                    Icon(Icons.Filled.AccountBox, contentDescription = "Image")
                }, label = {
                    Text("Another")
                })
            }
        }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
//            Text("Hello, world!")
//            Image(painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
            NavHost(
                navController = navController, startDestination = "DressScreen"
            ) {
                composable("DressScreen") {
                    DressScreen(viewModel = dressViewModel, onGoToAnother = {
                        navController.navigate("AnotherScreen")
                    })
                }
                composable("AnotherScreen") {
                    AnotherScreen()
                }
            }
        }
    }
}