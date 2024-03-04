package com.schooling.jetpackudemy.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.schooling.jetpackudemy.model.Movie
import com.schooling.jetpackudemy.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie.id)
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
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}