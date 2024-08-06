package com.example.jetpackcomposesample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(bottomBar = {
        MyNavigationBar(backStackEntry, navController)
    }) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .padding(it)
                .fillMaxSize()
        )
    }
}

@Composable
private fun MyNavigationBar(
    backStackEntry: State<NavBackStackEntry?>,
    navController: NavHostController
) {
    val bottomNavItems = bottomNavItems()

    NavigationBar {
        bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                label = { Text(text = item.name) },
                icon = { Icon(imageVector = item.icon, contentDescription = "${item.name} Icon") }
            )
        }
    }
}

@Composable
private fun bottomNavItems() = listOf(
    BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "Create",
        route = "add",
        icon = Icons.Rounded.AddCircle,
    ),
    BottomNavItem(
        name = "Settings",
        route = "settings",
        icon = Icons.Rounded.Settings,
    )
)

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)