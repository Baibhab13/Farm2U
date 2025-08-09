package com.example.farm2u.view.farmer

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.farm2u.R
import com.example.farm2u.model.Order

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FarmerOrders(navController: NavController) {
    // Sample list of orders
    val orders = listOf(
        Order("Order 1", "Location 1", 10, R.drawable.tomato),
        Order("Order 2", "Location 2", 20, R.drawable.potato),
        Order("Order 3", "Location 3", 15, R.drawable.carrot)
    )

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Orders", modifier = Modifier.padding(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(orders.size) { index ->
                    OrderItem(order = orders[index], navController = navController)
                }
            }
        }
    }
}

@Composable
fun OrderItem(order: Order, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = order.productImage), contentDescription = "Product Image", modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = order.productName)
                Text(text = "Location: ${order.location}")
                Text(text = "Quantity: ${order.quantity}")
            }
            Button(onClick = { navController.navigate("order_detail/${order.productName}") }) {
                Text("View Details")
            }
        }
    }
}
