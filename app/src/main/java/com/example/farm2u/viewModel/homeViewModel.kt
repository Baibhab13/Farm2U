package com.example.farm2u.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farm2u.R
import com.example.farm2u.model.CategoryItems
import com.example.farm2u.model.ProductItem
import kotlin.random.Random

//class HomeViewModel: ViewModel() {
//    val searchText = mutableStateOf("")
//
//    val categoryItems = listOf(
//        CategoryItems("All", R.drawable.basket ),
//        CategoryItems("Fruits", R.drawable.fruits ),
//        CategoryItems("Vegetables", R.drawable.vegetable ),
//        CategoryItems("Grains", R.drawable.grains ),
//    )
//
//    val productItems = listOf(
//        ProductItem(1,"Tomato", "Ramu's Farm", Random.nextInt(100), R.drawable.tomato),
//        ProductItem(2,"Potato", "Kalia's Farm", Random.nextInt(100), R.drawable.potato),
//        ProductItem(3,"Apple", "Ramesh's Farm", Random.nextInt(100), R.drawable.apple),
//        ProductItem(4,"Banana", "Suresh's Farm", Random.nextInt(100), R.drawable.banana),
//        ProductItem(5,"Carrot", "Raju's Farm", Random.nextInt(100), R.drawable.carrot),
//        ProductItem(6,"Wheat", "Jaya's Farm", Random.nextInt(100), R.drawable.wheat),
//        ProductItem(7,"Rice", "Vasant's Farm", Random.nextInt(100), R.drawable.rice),
//        ProductItem(8,"Jowar", "Mehboob's Farm", Random.nextInt(100), R.drawable.jowar),
//        ProductItem(9,"Onion", "Titu's Farm", Random.nextInt(100), R.drawable.onion),
//        ProductItem(10,"Onion", "Titu's Farm", Random.nextInt(100), R.drawable.onion),
//    )
//}

class HomeViewModel : ViewModel() {
    val searchText = mutableStateOf("")
    val selectedCategory = mutableStateOf("All") // Default to all products

    val categoryItems = listOf(
        CategoryItems("All", R.drawable.basket),
        CategoryItems("Fruits", R.drawable.fruits),
        CategoryItems("Vegetables", R.drawable.vegetable),
        CategoryItems("Grains", R.drawable.grains),
    )

    val productItems = listOf(
        ProductItem(1, "Tomato", "Ramu's Farm", Random.nextInt(100), R.drawable.tomato),
        ProductItem(2, "Potato", "Kalia's Farm", Random.nextInt(100), R.drawable.potato),
        ProductItem(3, "Apple", "Ramesh's Farm", Random.nextInt(100), R.drawable.apple),
        ProductItem(4, "Banana", "Suresh's Farm", Random.nextInt(100), R.drawable.banana),
        ProductItem(5, "Carrot", "Raju's Farm", Random.nextInt(100), R.drawable.carrot),
        ProductItem(6, "Wheat", "Jaya's Farm", Random.nextInt(100), R.drawable.wheat),
        ProductItem(7, "Rice", "Sai's Farm", Random.nextInt(100), R.drawable.rice),
        ProductItem(8, "Jowar", "Rabi's Farm", Random.nextInt(100), R.drawable.jowar),
        ProductItem(9, "Onion", "Titu's Farm", Random.nextInt(100), R.drawable.onion),
    )
}
