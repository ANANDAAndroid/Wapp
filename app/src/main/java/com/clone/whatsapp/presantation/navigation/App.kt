package com.clone.whatsapp.presantation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.clone.whatsapp.domain.utils.Route
import com.clone.whatsapp.presantation.activity.MainActivity
import com.clone.whatsapp.presantation.screens.OTPScreen
import com.clone.whatsapp.presantation.screens.PhoneNumberScreen
import com.clone.whatsapp.presantation.screens.WelcomeScreen

@Preview(showSystemUi = true)
@Composable

fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "auth",
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(700)
            )
        }
    ) {

        navigation(startDestination = Route.WELCOME.name, route = "auth") {
            composable(route = Route.WELCOME.name) {
                WelcomeScreen {
                    navController.navigate(route = Route.PHONE_NUMBER.name)
                }
            }
            composable(route = Route.PHONE_NUMBER.name) {
                PhoneNumberScreen {
                    navController.navigate(route = Route.OTP.name + "/$it")
                }
            }
            composable(
                route = Route.OTP.name + "/{phone_number}",
                arguments = listOf(navArgument("phone_number") {
                    type = NavType.StringType
                })
            ) {
                val phoneNumber = it.arguments?.getString("phone_number")
                OTPScreen(phoneNumber, onBack = {
                    navController.popBackStack()
                }) {
                    navController.navigate(route = "main_activity")
                }
            }
            activity(route = "main_activity") {
                activityClass = MainActivity::class
            }
        }

    }
}