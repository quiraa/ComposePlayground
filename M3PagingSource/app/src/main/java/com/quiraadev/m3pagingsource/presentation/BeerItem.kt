package com.quiraadev.m3pagingsource.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.quiraadev.m3pagingsource.domain.Beer
import com.quiraadev.m3pagingsource.ui.theme.M3PagingSourceTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(3f)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    M3PagingSourceTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Beer",
                tagline = "Beer Tagline",
                description = "Beer Description",
                imageUrl = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}