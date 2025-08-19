package dev.vengateshm.multimodularnavigationudemy

import androidx.compose.ui.window.ComposeUIViewController
import dev.vengateshm.multimodularnavigationudemy.recipes.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initializeKoin()
    }
) { App() }