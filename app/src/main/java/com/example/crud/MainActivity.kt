package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.crud.UI.screen.DressScreen
import com.example.crud.UI.viewModel.DressViewModel

import com.example.crud.ui.theme.CRUDTheme


class MainActivity : ComponentActivity() {
    val dressViewModel = DressViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUDTheme {
                DressScreen(viewModel = dressViewModel)
            }
        }
    }
}
//changes

//}