package dev.vengateshm.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.common.shared.navigation.Screen
import dev.vengateshm.root.RootScreen
import dev.vengateshm.settings.SettingsScreen

@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = Screen.Root
    ) {
        composable<Screen.Root> {
//            root {
//                navController.navigate(Screen.Settings)
//            }
            RootScreen(
                drawerState = drawerState,
                navigateToSettings = {
//                    navigateToSettings()
                    navController.navigate(Screen.Settings)
                }
            )
        }
        composable<Screen.Settings> {
            SettingsScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}