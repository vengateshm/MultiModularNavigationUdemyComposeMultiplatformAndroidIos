package dev.vengateshm.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.vengateshm.common.shared.domain.RecipesRepository
import dev.vengateshm.common.shared.domain.foodRecipes
import dev.vengateshm.details.component.ExpandableCard
import dev.vengateshm.details.domain.RecipeCard
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    id: Int,
    navigateBack: () -> Unit
) {
//    val recipes = foodRecipes
//    val selectedRecipe by remember {
//        derivedStateOf {
//            recipes.first { it.id == id }
//        }
//    }
//    val repository = koinInject<RecipesRepository>()
//    val viewModel = viewModel { DetailViewModel(repository = repository) }
    val viewModel = koinViewModel<DetailViewModel>()
    val selectedRecipe = viewModel.getSelectedRecipe(id)
    var expandedRecipeCard: RecipeCard? by remember {
        mutableStateOf(null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(
                        onClick = navigateBack
                    ){
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back arrow"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.toggleFavorite(selectedRecipe.id)
                        }
                    ){
                        Icon(
                            modifier = Modifier.alpha(if (selectedRecipe.isFavorite) 1f else 0.38f),
                            imageVector = Icons.Default.Star,
                            contentDescription = "Save Icon"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CoilImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 12.dp))
                    .height(300.dp)
                    .fillMaxWidth(),
                imageModel = { selectedRecipe.image },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = selectedRecipe.category,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
                SuggestionChip(
                    onClick = {},
                    label = {
                        Text(
                            text = "${selectedRecipe.preparationTime} mins",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                    }
                )
            }
            Text(
                text = selectedRecipe.title,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(text = selectedRecipe.description)
            Spacer(modifier = Modifier.height(24.dp))
            ExpandableCard(
                expanded = expandedRecipeCard == RecipeCard.Ingredients,
                title = "Ingredients",
                description = selectedRecipe.ingredients,
                onClick = {
                    expandedRecipeCard = if (expandedRecipeCard == RecipeCard.Ingredients)
                        null else RecipeCard.Ingredients
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            ExpandableCard(
                expanded = expandedRecipeCard == RecipeCard.Instructions,
                title = "Instructions",
                description = selectedRecipe.instructions,
                onClick = {
                    expandedRecipeCard = if (expandedRecipeCard == RecipeCard.Instructions)
                        null else RecipeCard.Instructions
                }
            )
        }
    }
}