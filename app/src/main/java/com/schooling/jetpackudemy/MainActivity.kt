package com.schooling.jetpackudemy

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackUdemyTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.shadow(
                        elevation = 5.dp
                    ), title = { Text(text = "Movie App") }, colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                content()
            }
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Titanic",
        "Gladiator",
        "The Lord of the Rings: The Fellowship of the Ring",
        "The Dark Knight",
        "Inception",
        "The Matrix",
        "Forrest Gump",
        "Jurassic Park",
        "The Lion King",
        "Star Wars: Episode IV - A New Hope",
        "Jaws",
        "E.T. the Extra-Terrestrial",
        "The Shawshank Redemption",
        "The Godfather",
        "Pulp Fiction",
        "The Silence of the Lambs",
        "Schindler's List",
        "Fight Club",
        "Braveheart",
        "The Green Mile",
        "The Godfather: Part II",
        "Goodfellas",
        "Saving Private Ryan",
        "The Departed",
        "The Terminator",
        "Die Hard",
        "Raiders of the Lost Ark",
        "Indiana Jones and the Last Crusade",
        "The Sixth Sense",
        "The Shining",
        "A Clockwork Orange",
        "Blade Runner",
        "The Exorcist",
        "Alien",
        "The Princess Bride",
        "Back to the Future",
        "Toy Story",
        "The Wizard of Oz",
        "The Sound of Music",
        "Grease",
        "The Breakfast Club",
        "Ferris Bueller's Day Off",
        "Home Alone",
        "The Goonies",
        "Ghostbusters",
        "Dirty Dancing",
        "Pretty Woman",
        "The Notebook",
        "Titanic",
        "The Great Gatsby",
        "Avatar",
        "300",
        "Harry Potter and the Sorcerer's Stone",
        "Harry Potter and the Chamber of Secrets",
        "Harry Potter and the Prisoner of Azkaban",
        "Harry Potter and the Goblet of Fire",
        "Harry Potter and the Order of the Phoenix",
        "Harry Potter and the Half-Blood Prince",
        "Harry Potter and the Deathly Hallows: Part 1",
        "Harry Potter and the Deathly Hallows: Part 2",
        "Twilight",
        "The Hunger Games",
        "Divergent",
        "Maze Runner",
        "The Fault in Our Stars",
        "The Perks of Being a Wallflower",
        "Mean Girls",
        "Clueless",
        "Legally Blonde",
        "Pitch Perfect",
        "La La Land",
        "The Greatest Showman",
        "A Star is Born",
        "Bohemian Rhapsody",
        "Rocketman",
        "Black Panther",
        "Avengers: Infinity War",
        "Guardians of the Galaxy",
        "Deadpool",
        "Spider-Man: Homecoming",
        "Iron Man",
        "Captain America: The First Avenger",
        "Thor",
        "Doctor Strange",
        "Wonder Woman",
        "Aquaman",
        "The Dark Knight Rises",
        "Batman Begins",
        "Man of Steel",
        "Superman Returns",
        "X-Men",
        "The Wolverine",
        "Deadpool 2",
        "The Avengers",
        "Captain America: The Winter Soldier",
        "Iron Man 3",
        "Thor: Ragnarok",
        "Guardians of the Galaxy Vol. 2",
        "Spider-Man: Into the Spider-Verse",
        "Black Widow"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it){movie ->
                    Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                       onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(6.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie App")
            }
            Text(text = movie)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}
