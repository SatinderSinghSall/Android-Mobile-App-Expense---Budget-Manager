package com.example.expensebudgetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.expensebudgetmanager.navigation.AppNavGraph
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔥 Initialize Firebase here
        FirebaseApp.initializeApp(this)

        setContent {
            MaterialTheme {
                AppRoot()   // Jetpack Compose UI starts here
            }
        }
    }
}

@Composable
fun AppRoot() {
    AppNavGraph()
}
