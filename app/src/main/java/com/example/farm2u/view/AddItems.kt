package com.example.farm2u.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.farm2u.viewModel.AddItemViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddItems(navController: NavController, viewModel: AddItemViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Product Name",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = viewModel.name.value,
                onValueChange = { viewModel.name.value = it },
                label = { Text("Product Name") },
                placeholder = { Text(text = "E.g. Tomatoes") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Crop Type",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                value = viewModel.cropType.value,
                onValueChange = { viewModel.cropType.value = it },
                label = { Text("Product Name") },
                placeholder = { Text(text = "Description") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Quantity(viewModel)
            Spacer(modifier = Modifier.padding(10.dp))
            Buttons(navController)
        }
    }
}

@Composable
fun Buttons(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween, // Ensures space between buttons
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(end = 5.dp), // Add spacing between the buttons
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = "Add Item")
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(start = 5.dp), // Add spacing between the buttons
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = "Cancel")
        }
    }
}

@Composable
fun Quantity(viewModel: AddItemViewModel = viewModel()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(
                text = "Quantity",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = viewModel.price.value,
                onValueChange = { viewModel.price.value = it },
                label = { Text("Price (per Kg)") },
                placeholder = { Text(text = "E.g. 100") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(
                text = "Price",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = viewModel.quantity.value,
                onValueChange = { viewModel.quantity.value = it },
                label = { Text("Quantity") },
                placeholder = { Text(text = "E.g. 10.kg") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        title = { Text(text = "") },
    )
}