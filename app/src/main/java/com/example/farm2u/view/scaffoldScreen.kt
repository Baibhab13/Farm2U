package com.example.farm2u.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.R
import com.example.farm2u.viewModel.HomeViewModel
import com.example.farm2u.viewModel.ScaffoldViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldScreen(navController: NavHostController,viewModel: ScaffoldViewModel = viewModel()) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Topbar(navController = rememberNavController())
        },
        bottomBar = {
            BottomNavigation()
        },
        floatingActionButton = {
            Fab(navController)
        }
    ) {
        ContentScreen()
    }
}

@Composable
fun ContentScreen(viewModel: ScaffoldViewModel = viewModel()) {
    when(viewModel.selectedIndex.intValue) {
        0 -> Home(
            navController = rememberNavController(),
            viewModel = HomeViewModel()
        )
        1 -> Favourites()
        2 -> ShoppingCart()
        3 -> Profile()
    }
}

@Composable
fun Fab(navController: NavHostController) {
    FloatingActionButton(onClick = {
        navController.navigate("chatbot")
    }) {
        Image(painterResource(R.drawable.chatbot), contentDescription = "chatbot", modifier = Modifier.size(35.dp))
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
fun Topbar(navController: NavHostController, viewModel: ScaffoldViewModel = viewModel()) {
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
                3 -> Text("Profile")
            }
        },
        actions = {
            // Notification Icon
            IconButton(onClick = {
                /*TODO*/
            }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            }
            // Message Icon
            IconButton(onClick = {
                /*TODO*/
            }) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Messages"
                )
            }
            // Settings Dropdown Menu
            IconButton(onClick = { viewModel.expandeds.value = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options"
                )
            }
            DropdownMenu(
                expanded = viewModel.expandeds.value,
                onDismissRequest = { viewModel.expandeds.value = false }
            ) {
                DropdownMenuItem(
                    text = { Text("language") },
                    onClick = {
                        //a dropdown menu appear to choose a language
                        viewModel.expandeds.value = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        viewModel.onDropdownItemClick("Logout")
                        viewModel.expandeds.value = false
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ScaffoldScreen(navController = rememberNavController())
}