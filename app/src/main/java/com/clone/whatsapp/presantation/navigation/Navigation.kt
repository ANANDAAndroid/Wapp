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
import com.clone.whatsapp.domain.utils.Constant.menuListChat
import com.clone.whatsapp.domain.utils.Route
import com.clone.whatsapp.presantation.activity.MainActivity
import com.clone.whatsapp.presantation.screens.LinkedDevice
import com.clone.whatsapp.presantation.screens.OTPScreen
import com.clone.whatsapp.presantation.screens.ParentScreen
import com.clone.whatsapp.presantation.screens.PaymentIntro
import com.clone.whatsapp.presantation.screens.Payments
import com.clone.whatsapp.presantation.screens.PhoneNumberScreen
import com.clone.whatsapp.presantation.screens.ScanQrCode
import com.clone.whatsapp.presantation.screens.StarredMessage
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

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main navigation",
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
        }) {
        navigation(startDestination = Route.PARENT_SCREEN.name, route = "main navigation") {
            composable(route = Route.PARENT_SCREEN.name) {
                ParentScreen {
                    when (it) {
                        menuListChat[0] -> {}
                        menuListChat[1] -> {}
                        menuListChat[2] -> navController.navigate(route = "linked devices navigation")
                        menuListChat[3] -> navController.navigate(route = Route.STARRED_MESSAGE.name)
                        menuListChat[4] -> navController.navigate(route = "payment navigation")
                        menuListChat[5] -> {}
                    }
                }
            }

        }
        composable(route = Route.STARRED_MESSAGE.name) {
            StarredMessage {
                navController.popBackStack()
            }
        }
        navigation(
            startDestination = Route.LINKED_DEVICES.name,
            route = "linked devices navigation"
        ) {
            composable(route = Route.LINKED_DEVICES.name) {
                LinkedDevice(onBack = {
                    navController.popBackStack()
                }) {
                    navController.navigate(route = Route.SCAN_QR.name)
                }
            }
            composable(route = Route.SCAN_QR.name) {
                ScanQrCode(onBack = {
                    navController.popBackStack()
                })
            }

        }
        navigation(
            startDestination = Route.PAYMENTS_INTRO.name,
            route = "payment navigation"
        ) {
            composable(route = Route.PAYMENTS_INTRO.name) {
                PaymentIntro{
                    navController.navigate(route=Route.PAYMENT.name)
                }
            }
            composable(route = Route.PAYMENT.name) {
                Payments(onBack = {
                    navController.popBackStack(route = Route.PAYMENTS_INTRO.name,inclusive = true)
                })
            }

        }

    }
}