package dev.vengateshm.multimodularnavigationudemy.recipes.di

import dev.vengateshm.common.shared.di.repositoryModule
import dev.vengateshm.di.koinModules
import org.koin.core.context.startKoin

fun initializeKoin() {
    startKoin {
        modules(repositoryModule, koinModules)
    }
}