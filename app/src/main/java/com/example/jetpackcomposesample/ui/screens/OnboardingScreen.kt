package com.example.jetpackcomposesample.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

private const val TAG = "OnboardingScreen"

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = {}
        ) {
            Text("Sample")
        }
    }

    val context = LocalContext.current
    MyLifecycleObserver(lifecycleOwner) { event ->
        Log.d(TAG, "OnboardingScreen: $event")
        when (event) {
            Lifecycle.Event.ON_START, Lifecycle.Event.ON_STOP -> Toast.makeText(
                context,
                "$event",
                Toast.LENGTH_SHORT
            ).show()

            else -> {}
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    JetpackComposeSampleTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Composable
fun MyLifecycleObserver(
    lifecycleOwner: LifecycleOwner,
    onLifecycleEvent: (Lifecycle.Event) -> Unit
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            onLifecycleEvent(event)
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            Log.d(TAG, "MyLifecycleObserver: onDispose")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}