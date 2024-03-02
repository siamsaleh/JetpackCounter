package com.schooling.jetpackudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.schooling.jetpackudemy.ui.theme.JetpackUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackUdemyTheme {
                // Counter Done
                MyApp()
            }
        }
    }
}


@Preview(showSystemUi = true, device = "id:pixel_5")
@Composable
fun MyApp() {
    val moneyCounter = remember {
        mutableIntStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color.Blue
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$${moneyCounter.intValue}", style = TextStyle(
                fontSize = 39.sp),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter = moneyCounter.intValue){newValue ->
                moneyCounter.intValue = newValue
            }
            if (moneyCounter.intValue > 25){
                Text(text = "Lots of Money", style = TextStyle(
                    fontSize = 15.sp),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CreateCircle(moneyCounter: Int = 0, UpdateMoneyCounter: (Int) -> Unit) { // Unit is return nothing
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(150.dp), shape = CircleShape,
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, color = Color.Red)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    UpdateMoneyCounter(moneyCounter + 1)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap", fontSize = 25.sp, modifier = Modifier)
        }
    }
}
