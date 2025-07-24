package com.example.modelviewviewmodel

import ItemCounter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.modelviewviewmodel.StateFlow.LiftScreen
import com.example.modelviewviewmodel.StateFlow.LiftViewModel
import com.example.modelviewviewmodel.architecture.ArchitectureScreen
import com.example.modelviewviewmodel.state.CoffeeCounter
import com.example.modelviewviewmodel.state.DerivedStateScreen
import com.example.modelviewviewmodel.state.StateScreen
import com.example.modelviewviewmodel.ui.theme.ModelViewViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModelViewViewModelTheme {
//                ArchitectureScreen()
//                StateScreen()
//                CoffeeCounter()
//                DerivedStateScreen()
                LiftScreen(viewModel = LiftViewModel())
            }
        }
    }
}