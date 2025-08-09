package com.example.farm2u.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.R
import com.example.farm2u.navigation.Screens
import com.example.farm2u.viewModel.HomeViewModel
import com.example.farm2u.viewModel.ScaffoldViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldScreen(navController: NavController, viewModel: ScaffoldViewModel) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Topbar(navController = rememberNavController())
        },
        bottomBar = {
            BottomNavigation()
        },
        floatingActionButton = {
            when(viewModel.selectedIndex.intValue) {
                0 -> Fab(navController)
            }
        }
    ) {
        ContentScreen(navController)
    }
}

@Composable
fun ContentScreen(navController: NavController, viewModel: ScaffoldViewModel = viewModel()) {
    when(viewModel.selectedIndex.intValue) {
        0 -> Home(navController, viewModel = HomeViewModel())
        1 -> Favourites(navController)
        2 -> ShoppingCart(navController)
        3 -> Negotiate(navController)
    }
}

@Composable
fun Fab(navController: NavController) {
    FloatingActionButton(onClick = {
        navController.navigate("chatbot")
    }) {
        Image(painterResource(R.drawable.chatbot),
            contentDescription = "chatbot",
            modifier = Modifier.size(35.dp)
        )
    }
}

@Composable
fun BottomNavigation(viewModel: ScaffoldViewModel = viewModel()) {
    NavigationBar {
        viewModel.navItemList.forEachIndexed { index, _ ->
            NavigationBarItem(
                selected = viewModel.selectedIndex.intValue == index,
                onClick = {
                    viewModel.selectedIndex.intValue = index
                },
                icon = { Icon(imageVector = viewModel.navItemList[index].icon,
                    contentDescription = viewModel.navItemList[index].label)
                },
                label = { Text(text = viewModel.navItemList[index].label) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(navController: NavController, viewModel: ScaffoldViewModel = viewModel()) {
    TopAppBar(
        navigationIcon = {
            Image(painterResource(R.drawable.no_bg_logo_2),
                contentDescription = "logo",
                modifier = Modifier.size(30.dp)
                    .padding(5.dp),
            )
        },
        title = {
            when(viewModel.selectedIndex.intValue) {
                0 -> Text("Farm2U")
                1 -> Text("Favourites")
                2 -> Text("Shopping Cart")
                3 -> Text("Negotiation")
            }
        },
        actions = {
            //Dropdown Menu
            IconButton(onClick = { viewModel.expanded.value = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options"
                )
            }
            DropdownMenu(
                modifier = Modifier.width(150.dp),
                expanded = viewModel.expanded.value,
                onDismissRequest = { viewModel.expanded.value = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        //a dropdown menu appear to choose a language
                        navController.navigate(Screens.Profile.route)
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Language") },
                    onClick = {
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Setting") },
                    onClick = {
                        viewModel.expanded.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        viewModel.expanded.value = false
                    }
                )
            }
        }
    )
}