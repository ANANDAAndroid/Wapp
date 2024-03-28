package com.clone.whatsapp.presantation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.clone.whatsapp.presantation.SplashActivityTheme
import com.clone.whatsapp.presantation.activity.ui.theme.WappTheme
import com.clone.whatsapp.presantation.navigation.App
import com.clone.whatsapp.presantation.screens.OTPScreen
import com.clone.whatsapp.presantation.screens.PhoneNumberScreen
import com.clone.whatsapp.presantation.screens.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // WelcomeScreen()
                   // PhoneNumberScreen()
                    //OTPScreen()
                    App()
                }
            }
        }
    }
}

