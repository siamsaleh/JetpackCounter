package com.schooling.jetpackudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.schooling.jetpackudemy.ui.theme.JetpackUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit) {
    JetpackUdemyTheme {
        content()
    }
}

@Composable
fun MainContent(){
    Surface(color = MaterialTheme.colorScheme.background) {
        Text(text = "Hello")
    }
}

@Preview
@Composable
fun DefaultPreview(){
    MyApp {
        MainContent()
    }
}
