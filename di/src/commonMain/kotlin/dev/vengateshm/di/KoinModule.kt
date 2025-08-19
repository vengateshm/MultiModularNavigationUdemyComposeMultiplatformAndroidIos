package dev.vengateshm.di

import dev.vengateshm.details.DetailViewModel
import dev.vengateshm.home.HomeViewModel
import dev.vengateshm.saved.SavedViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val koinModules = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { SavedViewModel(get()) }
}