package dev.vengateshm.common.shared.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Root : Screen()

    @Serializable
    data object HomeGraph : Screen()

    @Serializable
    data object Home : Screen()

    @Serializable
    data class Details(val id: Int) : Screen()

    @Serializable
    data object Saved : Screen()

    @Serializable
    data object Joke : Screen()

    @Serializable
    data object Settings : Screen()
}