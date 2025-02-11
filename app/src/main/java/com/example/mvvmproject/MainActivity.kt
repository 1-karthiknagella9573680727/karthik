package com.example.mvvmproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mvvmproject.view.ItemScreen
import com.example.mvvmproject.ui.theme.MVVMProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMProjectTheme {
                // Ensure you have a Composable here
                Surface(color = MaterialTheme.colorScheme.background) {
                    ItemScreen()  // Make sure this composable is properly called
                }
            }
        }
    }
}


