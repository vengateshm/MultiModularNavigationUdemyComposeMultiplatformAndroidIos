package dev.vengateshm.details

import androidx.lifecycle.ViewModel
import dev.vengateshm.common.shared.domain.RecipesRepository

class DetailViewModel(
    private val repository: RecipesRepository
) : ViewModel() {
    fun getSelectedRecipe(recipeId: Int) = repository.getSelectedRecipe(recipeId)
    fun toggleFavorite(recipeId: Int) = repository.toggleFavorite(recipeId)
}