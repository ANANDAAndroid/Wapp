package com.clone.whatsapp.domain.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clone.whatsapp.R
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.SecondaryColor


@Composable
fun TopBar(modifier: Modifier = Modifier, title: String = "",onClick:()-> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(SecondaryColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
        Text(
            text = title,
            fontFamily = RobotoBold,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
    }

}