package com.example.multiverseradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import com.example.multiverseradar.ui.CharacterScreen
import com.example.multiverseradar.ui.CharacterViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CharacterViewModel by viewModels {
        CharacterViewModel.Factory((application as MultiverseApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                CharacterScreen(viewModel)
            }
        }
    }
}
