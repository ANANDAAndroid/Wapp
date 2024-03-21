package com.clone.whatsapp.presantation.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.LifecycleEvent
import com.clone.whatsapp.presantation.RobotoRegular


@Composable
fun SplashScreen(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {

    LifecycleEvent(
        lifecycleOwner = lifecycleOwner,
        onCreate = {
            Log.i("TAG", "SplashScreen: create")
        },
        onStart = {
            Log.i("TAG", "SplashScreen: start")
        },
        onResume = {
            Log.i("TAG", "SplashScreen: resume")
        },
        onPause = {
            Log.i("TAG", "SplashScreen: pause")
        },
        onStop = {
            Log.i("TAG", "SplashScreen: stop")
        },
        onDestroy = {
            Log.i("TAG", "SplashScreen: destroy")
        })


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "App logo",
            alignment = Alignment.Center,
            modifier = Modifier.size(80.dp)
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 50.dp)
        ) {
            Text(
                text = "from",
                fontFamily = RobotoRegular,
                color = colorResource(id = R.color.from_text_color)
            )
            Text(
                text = "FACEBOOK",
                fontFamily = RobotoRegular,
                color = colorResource(id = R.color.facebook_text_color)
            )
        }
    }

}