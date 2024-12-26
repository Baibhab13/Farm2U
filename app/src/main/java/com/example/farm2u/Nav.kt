package com.example.farm2u

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.view.AboutUs
import com.example.farm2u.view.ChatPage
import com.example.farm2u.view.FarmerHome
import com.example.farm2u.view.FarmerScaffold
import com.example.farm2u.view.Favourites
import com.example.farm2u.view.ForgotPassword
import com.example.farm2u.view.Home
import com.example.farm2u.view.LandingPage
import com.example.farm2u.view.Login
import com.example.farm2u.view.Profile
import com.example.farm2u.view.ScaffoldScreen
import com.example.farm2u.view.SignUp

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Nav() {
    val navCtrl = rememberNavController()
    NavHost(navController = navCtrl, startDestination = "landingPage") {

        //////////////////////////////* Landing Page *//////////////////////////////////////

        composable("landingPage") {
            LandingPage(navController = navCtrl)
        }

        composable("about us") {
            AboutUs()
        }

        //////////////////////////////* Authentication Pages *//////////////////////////////////////


        composable("login / {usertype}") { backStackEntry ->
            val usertype = backStackEntry.arguments?.getString("usertype") ?: "buy"
            Login(navController = navCtrl, usertype = usertype)
        }

        composable("signup") {
            SignUp(navController = navCtrl)
        }

        composable("forgot") {
            ForgotPassword(navController = navCtrl)
        }

        ///////////////////////* Buyer's Screen*/////////////////////////////

        composable("scaffold") {
            ScaffoldScreen(navController = navCtrl, viewModel = viewModel())
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

        composable("profile") {
            Profile(navController = navCtrl)
        }

        ///////////////////* Farmer's Screen */////////////////////////////////

        composable("farmer scaffold") {
            FarmerScaffold(
                navController = navCtrl,
                viewModel = viewModel()
            )
        }

        composable("farmer home") {
            FarmerHome(navController = navCtrl)
        }

    }
}


