package com.clone.whatsapp.presantation.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.clone.whatsapp.R
import com.clone.whatsapp.presantation.SplashActivityTheme
import com.clone.whatsapp.presantation.screens.SplashScreen

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
            overridePendingTransition(0,android.R.anim.fade_in)
        },100)
        setContent {
            SplashActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen()
                }
            }
        }
    }
}
