package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.example.jetpackcomposesample.ui.screens.Greeting
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
//                Conversation(messages = SampleData.conversationSample)
//                BoxExperimental()
                Column {
                    listOf("World", "Compose").forEach {
                        Greeting(name = it)
                    }
                }
            }
        }
    }
}