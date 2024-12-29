package com.example.farm2u.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.farm2u.view.AboutUs
import com.example.farm2u.view.AddItems
import com.example.farm2u.view.ChatPage
import com.example.farm2u.view.ChatScreen
import com.example.farm2u.view.Crop
import com.example.farm2u.view.Farm
import com.example.farm2u.view.FarmerScaffold
import com.example.farm2u.view.Favourites
import com.example.farm2u.view.ForgotPassword
import com.example.farm2u.view.GridScreen
import com.example.farm2u.view.History
import com.example.farm2u.view.Home
import com.example.farm2u.view.Inventory
import com.example.farm2u.view.LandingPage
import com.example.farm2u.view.Login
import com.example.farm2u.view.Profile
import com.example.farm2u.view.ScaffoldScreen
import com.example.farm2u.view.SignUp

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun Nav() {
    val navCtrl = rememberNavController()
    NavHost(navController = navCtrl, startDestination = Screens.Auth.route) {

        navigation(startDestination = Screens.LandingPage.route, route = Screens.Auth.route) {

            composable(Screens.LandingPage.route) {
                LandingPage(navController = navCtrl)
            }

            composable(Screens.AboutUs.route) {
                AboutUs()
            }

            composable("login / {usertype}") { backStackEntry ->
                val usertype = backStackEntry.arguments?.getString("usertype") ?: "buy"
                Login(navController = navCtrl, usertype = usertype)
            }

            composable(Screens.SignUp.route) {
                SignUp(navController = navCtrl)
            }

            composable(Screens.ForgotPassword.route) {
                ForgotPassword(navController = navCtrl)
            }
        }


        ///////////////////////* Buyer's Screen*/////////////////////////////

        navigation(startDestination = Screens.Scaffold.route, route = Screens.Sell.route) {
            composable(Screens.Scaffold.route) {
                ScaffoldScreen(navController = navCtrl, viewModel = viewModel())
            }

            composable(Screens.Home.route) {
                Home(navController = navCtrl)
            }

            composable(Screens.Favourites.route) {
                Favourites(navcontroller =  navCtrl)
            }

            composable(Screens.Chatbot.route) {
                ChatPage(navController = navCtrl, viewModel = viewModel())
            }

            composable(Screens.Profile.route) {
                Profile(navController = navCtrl)
            }
        }

        ///////////////////* Farmer's Screen */////////////////////////////////
        navigation(startDestination = Screens.FarmerScaffold.route, route = Screens.Buy.route) {

            composable(Screens.FarmerScaffold.route) {
                FarmerScaffold(navController = navCtrl, viewModel = viewModel())
            }

            composable(Screens.GridScreen.route) {
                GridScreen(navController = navCtrl)
            }

            composable(Screens.Farm.route) {
                Farm(navController = navCtrl)
            }

            composable(Screens.Inventory.route) {
                Inventory(navController = navCtrl)
            }

            composable(Screens.History.route) {
                History(navController = navCtrl)
            }

            composable(Screens.Crop.route) {
                Crop(navController = navCtrl)
            }

            composable(Screens.AddItems.route) {
                AddItems(navController = navCtrl)
            }

            composable("chat/{userName}") { backStackEntry ->
                val userName = backStackEntry.arguments?.getString("userName")
                userName?.let {
                    ChatScreen(navController=navCtrl, userName)
                }
            }
        }
    }
}


