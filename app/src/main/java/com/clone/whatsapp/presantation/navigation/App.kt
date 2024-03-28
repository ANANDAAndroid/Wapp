package com.clone.whatsapp.presantation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.clone.whatsapp.domain.utils.Route
import com.clone.whatsapp.presantation.screens.OTPScreen
import com.clone.whatsapp.presantation.screens.PhoneNumberScreen
import com.clone.whatsapp.presantation.screens.WelcomeScreen

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.WELCOME.name) {
        composable(route = Route.WELCOME.name) {
            WelcomeScreen {
                navController.navigate(route = Route.PHONE_NUMBER.name)
            }
        }
        composable(route = Route.PHONE_NUMBER.name) {
            PhoneNumberScreen {
                navController.navigate(route = Route.OTP.name+"/$it")
            }
        }
        composable(route = Route.OTP.name + "/{phone_number}", arguments = listOf(navArgument("phone_number") {
            type = NavType.StringType
        })) {
            val phoneNumber=it.arguments?.getString("phone_number")
            OTPScreen(phoneNumber,onBack = {
                navController.popBackStack()
            }) {

            }
        }
    }
}