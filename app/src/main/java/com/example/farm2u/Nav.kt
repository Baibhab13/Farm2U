package com.example.farm2u

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.view.AboutUs
import com.example.farm2u.view.BuyLogin
import com.example.farm2u.view.ChatPage
import com.example.farm2u.view.Favourites
import com.example.farm2u.view.ForgotPassword
import com.example.farm2u.view.Home
import com.example.farm2u.view.LandingPage
import com.example.farm2u.view.ScaffoldScreen
import com.example.farm2u.view.SignUp

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Nav() {
    val navCtrl = rememberNavController()
    NavHost(navController = navCtrl, startDestination = "landingPage") {

        composable("landingPage") {
            LandingPage(navController = navCtrl)
        }

        composable("about us") {
            AboutUs()
        }

        composable("buylogin") {
            BuyLogin(navController = navCtrl)
        }

        composable("signup") {
            SignUp(navController = navCtrl)
        }

        composable("forgot") {
            ForgotPassword(navController = navCtrl)
        }

        ////////////////////////////////////////////////////

        composable("scaffold") {
            ScaffoldScreen(navController = navCtrl)
        }

        composable("home") {
            Home(navController = navCtrl)
        }

        composable("favourites") {
            Favourites()
        }

        composable("chatbot") {
            ChatPage(navController = navCtrl, viewModel = viewModel())
        }
    }
}

