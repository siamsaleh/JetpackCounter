package com.schooling.jetpackudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.schooling.jetpackudemy.navigation.MovieNavigation
import com.schooling.jetpackudemy.ui.theme.JetpackUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackUdemyTheme {
        content()
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}
