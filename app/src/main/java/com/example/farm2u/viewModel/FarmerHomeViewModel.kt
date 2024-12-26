package com.example.farm2u.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.farm2u.R
import com.example.farm2u.model.GridItem

class FarmerHomeViewModel : ViewModel(){
    var gridItems = mutableStateListOf<GridItem>()
        private set

    init {
        // Populate the grid with data
        loadGridItems()
    }

    private fun loadGridItems() {
        gridItems.addAll(
            listOf(
                GridItem("Farm", R.drawable.farm),
                GridItem("History", R.drawable.history),
                GridItem("Inventory", R.drawable.inventory),
                GridItem("Crops", R.drawable.crops)
            )
        )
    }
}

