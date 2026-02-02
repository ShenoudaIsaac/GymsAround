package com.shenouda.gymsaround.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.gymList
import com.shenouda.gymsaround.ui.theme.GymsAroundTheme
import com.shenouda.gymsaround.viewmodels.GymViewModel
import java.util.Vector

@Composable
fun GymsScreen (
) {
    val gymViewModel: GymViewModel=viewModel()
    var gymListState =gymViewModel.gymListState
    LazyColumn() {
        items(gymListState){gym->
            GymItem(gym) { gymViewModel.toggleFavoriteState(it) }
        }

    }
   }
@Composable
fun GymItem(gymData: Gym, onClick: (Int) -> Unit) {
    var favIcon = Default.FavoriteBorder
    if (gymData.isFavourite) {
        favIcon = Default.Favorite}
    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            DefaultIcon(Default.LocationOn, contentDescription = "location icon",modifier = Modifier.weight(0.15f),colorFilter = ColorFilter.tint(Color.DarkGray))
            GymDetails(gymData, modifier = Modifier.weight(0.7f))
            DefaultIcon(
                favIcon,
                contentDescription = "fav Icon",
                modifier = Modifier
                    .weight(0.15f),
                colorFilter = ColorFilter.tint(Color.Red)
            ) { onClick(gymData.gymId) }

        }
    }
}

@Composable
fun DefaultIcon(
    vector: ImageVector,
    contentDescription:String,
    modifier: Modifier,
    colorFilter: ColorFilter,
    onClick: () -> Unit ={}){
    Image(
        imageVector = vector,
        contentDescription = contentDescription,
        modifier = modifier.clickable { onClick() },
        colorFilter=colorFilter
    )
}
@Composable
fun GymDetails(gymData: Gym, modifier: Modifier){
    Column(
        modifier= modifier

    ) {
        Text(
            gymData.name,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            gymData.place,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewGymScreen() {
    GymsAroundTheme {
    }
    
}

