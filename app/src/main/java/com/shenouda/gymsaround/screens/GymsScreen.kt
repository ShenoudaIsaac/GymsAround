package com.shenouda.gymsaround.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shenouda.gymsaround.Gym
import com.shenouda.gymsaround.ui.theme.GymsAroundTheme
import com.shenouda.gymsaround.viewmodels.GymViewModel

@Composable
fun GymsScreen (
) {
    val gymViewModel: GymViewModel= viewModel()
    LazyColumn () {
        items(gymViewModel.getGymList()) {
            GymItem(it)
        }
}}
@Composable
fun GymItem(gymData: Gym){
    Card(elevation =CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier=Modifier.padding(4.dp)) {
            GymIcon(Default.LocationOn, modifier = Modifier.weight(0.15f))
            GymDetails(gymData,modifier= Modifier.weight(0.85f))
        }
    }
}

@Composable
fun GymIcon(vector: ImageVector,modifier: Modifier) {
    Image(
        imageVector = vector,
        contentDescription = "location icon",
        modifier=modifier,
        colorFilter = ColorFilter.tint(Color.DarkGray)
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
        GymsScreen()
    }
    
}

