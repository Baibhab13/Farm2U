package com.example.farm2u.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.farm2u.R
import com.example.farm2u.model.Order

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OrderDetailScreen(navController: NavController, productName: String) {
    // Sample order details (replace with actual data)
    val order = Order(productName, "Sample Location", 20, R.drawable.tomato)

    // State to control the visibility of "Track Order" button
    var isOrderConfirmed by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Order Details", modifier = Modifier.padding(16.dp))

            // Display order details
            Text(text = "Product: ${order.productName}")
            Text(text = "Location: ${order.location}")
            Text(text = "Quantity: ${order.quantity}")
            Image(
                painter = painterResource(id = order.productImage),
                contentDescription = "Product Image",
                modifier = Modifier.size(100.dp).padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Negotiation and Confirm buttons
            Button(onClick = {navController.navigate("negotiate price")}) {
                Text("Negotiate Price")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                isOrderConfirmed = true // Set order as confirmed
            }) {
                Text("Confirm Order")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Track order button (visible only after confirming the order)
            if (isOrderConfirmed) {
                Button(onClick = { navController.navigate("track_order") }) {
                    Text("Track Order")
                }
            }
        }
    }
}
