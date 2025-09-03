package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import com.example.crud.UI.screen.AppMain

import com.example.crud.UI.screen.DressScreen
import com.example.crud.UI.screen.OnBoardingScreen
import com.example.crud.UI.viewModel.DressViewModel

import com.example.crud.ui.theme.CRUDTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUDTheme {
                Scaffold (
                ){ innerPadding->
                    Column (
                        modifier = Modifier.padding(innerPadding)
                    ){
                        OnBoardingScreen()
                    }
                }
            }
        }
    }
}
//changes

//}