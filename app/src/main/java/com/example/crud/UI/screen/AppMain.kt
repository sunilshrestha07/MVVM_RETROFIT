package com.example.crud.UI.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crud.UI.viewModel.DressViewModel

@Composable
fun AppMain(
    dressViewModel: DressViewModel = DressViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {
                        navController.navigate("DressScreen")

                    },
                    icon = {
                    },
                    label = {
                        Text("Home")
                    }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {
                        navController.navigate("AnotherScreen")
                    },
                    icon = { },
                    label = {
                        Text("Home")
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
//            Text("Hello, world!")

            NavHost(
                navController = navController,
                startDestination = "DressScreen"
            ){
                composable("DressScreen"){
                    DressScreen(viewModel = dressViewModel, onGoToAnother={
                        navController.navigate("AnotherScreen")
                    })
                }
                composable("AnotherScreen"){
                    AnotherScreen()
                }
            }
        }
    }
}