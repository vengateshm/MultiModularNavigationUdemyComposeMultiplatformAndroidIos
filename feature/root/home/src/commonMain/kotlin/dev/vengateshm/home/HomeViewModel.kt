package dev.vengateshm.home

import androidx.lifecycle.ViewModel
import dev.vengateshm.common.shared.domain.RecipesRepository

class HomeViewModel(
    private val repository: RecipesRepository
) : ViewModel() {
    fun getAllRecipes() = repository.getAllRecipes()
}