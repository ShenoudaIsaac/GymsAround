package com.shenouda.gymsaround

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shenouda.gymsaround.screens.GymsScreen
import com.shenouda.gymsaround.ui.theme.GymsAroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymsAroundTheme {
                GymsScreen()
            }
        }
    }
}