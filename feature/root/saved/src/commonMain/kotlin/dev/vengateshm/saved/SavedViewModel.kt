package dev.vengateshm.saved

import androidx.lifecycle.ViewModel
import dev.vengateshm.common.shared.domain.RecipesRepository

class SavedViewModel(
    private val repository: RecipesRepository
) : ViewModel() {
    fun getSavedRecipes() = repository.getSavedRecipes()
}