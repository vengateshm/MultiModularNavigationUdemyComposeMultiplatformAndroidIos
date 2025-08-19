package dev.vengateshm.common.shared.di

import dev.vengateshm.common.shared.domain.RecipesRepository
import org.koin.dsl.module

val repositoryModule  = module {
    single { RecipesRepository() }
}