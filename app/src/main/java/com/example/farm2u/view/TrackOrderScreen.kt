package com.example.farm2u.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.farm2u.R // Replace with your actual resource path
import kotlin.math.pow
import kotlin.math.sqrt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TrackOrderScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Track Your Order",
                modifier = Modifier.padding(16.dp)
            )

            // Logistic Graph with Background Image
            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                LogisticGraph(backgroundImageRes = R.drawable.placeholder) // Replace with your actual image resource
            }
        }
    }
}

@Composable
fun LogisticGraph(backgroundImageRes: Int) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = backgroundImageRes),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        // Overlay Canvas
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Canvas size
            val canvasWidth = size.width
            val canvasHeight = size.height

            // Positions
            val farmer = Offset(x = canvasWidth * 0.2f, y = canvasHeight * 0.5f)
            val depot1 = Offset(x = canvasWidth * 0.5f, y = canvasHeight * 0.2f)
            val depot2 = Offset(x = canvasWidth * 0.5f, y = canvasHeight * 0.8f)
            val buyer1 = Offset(x = canvasWidth * 0.6f, y = canvasHeight * 0.4f)
            val buyer2 = Offset(x = canvasWidth * 0.9f, y = canvasHeight * 0.9f)

            // Calculate distances to determine connections
            val buyer1Distance = distanceBetween(farmer, buyer1)
            val buyer2Distance = distanceBetween(farmer, buyer2)

            // Determine closest buyer
            val closestBuyer = if (buyer1Distance < buyer2Distance) buyer1 else buyer2

            // Draw nodes (Farmer, Depots, Buyers)
            drawCircle(color = Color.Green, radius = 20f, center = farmer) // Farmer
            drawCircle(color = Color.Blue, radius = 20f, center = depot1) // Depot 1
            drawCircle(color = Color.Blue, radius = 20f, center = depot2) // Depot 2
            drawCircle(color = Color.Red, radius = 23f, center = buyer1) // Buyer 1
            drawCircle(color = Color.Red, radius = 20f, center = buyer2) // Buyer 2

            // Draw circle around farmer and closest buyer (smaller radius)
            val highlightRadius = distanceBetween(farmer, closestBuyer) + 20
            drawCircle(color = Color.LightGray.copy(alpha = 0.4f), radius = highlightRadius, center = farmer)

            // Draw connection between farmer and closest buyer
            drawLine(
                color = Color.Gray,
                start = farmer,
                end = closestBuyer,
                strokeWidth = 5f
            )

            // Draw depots and other buyers outside the circle
            val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), phase = 0f)
            drawLine(
                color = Color.Gray,
                start = farmer,
                end = depot1,
                strokeWidth = 5f,
                pathEffect = pathEffect
            )
            drawLine(
                color = Color.Gray,
                start = farmer,
                end = depot2,
                strokeWidth = 5f,
                pathEffect = pathEffect
            )
            drawLine(
                color = Color.Gray,
                start = farmer,
                end = buyer2,
                strokeWidth = 5f,
                pathEffect = pathEffect
            )
            drawLine(
                color = Color.Gray,
                start = depot2,
                end = buyer2,
                strokeWidth = 5f,
                pathEffect = pathEffect
            )
        }
    }
}

// Helper function to calculate the distance between two points
private fun distanceBetween(point1: Offset, point2: Offset): Float {
    return sqrt((point2.x - point1.x).pow(2) + (point2.y - point1.y).pow(2))
}

private fun Float.pow(exponent: Int): Float = this.toDouble().pow(exponent).toFloat()
