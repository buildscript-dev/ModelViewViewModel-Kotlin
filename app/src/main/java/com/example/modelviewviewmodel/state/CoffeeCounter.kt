package com.example.modelviewviewmodel.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(coffeeCount: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("You've had $coffeeCount cups of coffee.")
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = coffeeCount < 3) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var coffeeCount by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(coffeeCount, { coffeeCount++ }, modifier)
}
@Composable
fun CoffeeCounter() {
    StatefulCounter()
}