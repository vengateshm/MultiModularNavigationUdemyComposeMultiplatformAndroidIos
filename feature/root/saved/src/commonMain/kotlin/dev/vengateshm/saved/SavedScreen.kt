package dev.vengateshm.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.vengateshm.common.shared.component.RecipeView
import dev.vengateshm.common.shared.domain.RecipesRepository
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SavedScreen(
    navigateToDetails: (Int) -> Unit
) {
//    val repository = koinInject<RecipesRepository>()
//    val viewModel = viewModel { SavedViewModel(repository = repository) }
    val viewModel = koinViewModel<SavedViewModel>()
    val savedRecipes = viewModel.getSavedRecipes()

    if (savedRecipes.isNotEmpty()) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            columns = StaggeredGridCells.Fixed(count = 2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalItemSpacing = 12.dp
        ) {
            items(
                items = savedRecipes,
                key = { it.id }
            ) {
                RecipeView(
                    recipe = it,
                    onClick = navigateToDetails
                )
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No saved recipes.")
        }
    }
}