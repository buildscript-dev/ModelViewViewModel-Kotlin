package com.example.modelviewviewmodel.state

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DerivedStateScreen() {
    var name by remember { mutableStateOf("") }
    var money by remember { mutableIntStateOf(500) }
    val isButtonEnabled by remember {
        derivedStateOf { name.trim().isNotEmpty() }
    }
    var context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(Modifier.height(24.dp))

        Text("Hey $name, You Scored $$money M")

        Spacer(Modifier.height(16.dp))

        Button(onClick = { money += 100 }) {
            Text("Add Money 💸")
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            Toast.makeText(context, "${name} has received ${money}M successfully"
                , Toast.LENGTH_LONG).show()
             }, enabled = isButtonEnabled) {
            Text("Submit")
        }
    }
}
