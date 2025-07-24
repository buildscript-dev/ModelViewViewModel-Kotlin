package com.example.modelviewviewmodel.StateFlow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LiftScreen(viewModel: LiftViewModel) {
    val floor by viewModel.floor.collectAsState(initial = 0)
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hey, You are on $floor floor ")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.updateFloor(floor + 1) }) {
            Text("Next Floor")
        }
            Button(onClick = { viewModel.resetFloor(0) }) {
                Text("Reset Floor")

            }
        Button(onClick = { viewModel.previousFloor(floor - 1 ) }) {
                    Text("Previous Floor")
                }

    }
}


