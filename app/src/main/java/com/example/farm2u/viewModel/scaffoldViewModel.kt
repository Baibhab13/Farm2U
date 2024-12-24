package com.example.farm2u.viewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.farm2u.model.NavItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScaffoldViewModel: ViewModel() {
    val selectedIndex = mutableIntStateOf(0)

    val expandeds = mutableStateOf(false)


    private val _expanded = MutableStateFlow(false) // Dropdown menu state
    val expanded: StateFlow<Boolean> get() = _expanded

    fun onNotificationClick() {
        // Handle notification action
        println("Notification clicked")

    }

    fun onMessageClick() {
        // Handle message action
        println("Message clicked")
    }

    fun onDropdownToggle() {
        _expanded.value = !_expanded.value
    }

    fun onDropdownDismiss() {
        _expanded.value = false
    }

    fun onDropdownItemClick(s: String) {

    }

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Favourites", Icons.Filled.Favorite ),
        NavItem("Cart", Icons.Default.ShoppingCart),
        NavItem("Profile", Icons.Default.Person),
    )
}