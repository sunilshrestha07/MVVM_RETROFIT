package com.example.crud.UI.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crud.UI.viewModel.DressViewModel

@Composable
fun DressScreen(viewModel: DressViewModel = DressViewModel(), onGoToAnother: () -> Unit) {
    val dressList = viewModel.dress.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dress Lists")

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(dressList.value) { item ->
                Text(item.name)
                Text(item.username)
                Text(item.email)
                FilledTonalButton(onClick = {
                    onGoToAnother()
                }) {
                    Text("Go to Another Screen")
                }
                Spacer(modifier = Modifier.height(40.dp))

            }
        }
    }
}
