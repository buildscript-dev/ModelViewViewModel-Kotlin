import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count: Int, name : String, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("You've had $count cups of $name.")
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 3) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var coffeeCount by rememberSaveable { mutableStateOf(0 ) }
    var waterCount by rememberSaveable { mutableStateOf(0) }
    var juiceCount by rememberSaveable { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        StatelessCounter(coffeeCount, "Coffee" ,{ coffeeCount++ }, modifier)
        Spacer(modifier = Modifier.height(16.dp)) // Add space between counters
        StatelessCounter(waterCount, "Water" ,{ waterCount++ }, modifier)
        Spacer(modifier = Modifier.height(16.dp)) // Add space between counters
        StatelessCounter(juiceCount,"Juice" ,{ juiceCount++ }, modifier)
    }
}
@Composable
fun ItemCounter() {
    StatefulCounter()
}
