package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.ui.screens.Greetings
import com.example.jetpackcomposesample.ui.screens.OnboardingScreen
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
//                Conversation(messages = SampleData.conversationSample)
//                BoxExperimental()
//                Greetings()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "onboarding") {
                    composable("onboarding") {
                        OnboardingScreen(onContinueClicked = { navController.navigate("greetings") })
                    }
                    composable("greetings") {
                        Greetings()
                    }
                    composable("home") {
                        OnboardingScreen(onContinueClicked = { navController.navigate("greetings") })
                    }
                    composable("add") {
                        Greetings()
                    }
                }
//                MyApp(navController)
            }
        }
    }
}