package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.SecondaryColor


@Preview(showSystemUi = true)
@Composable
fun ParentScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (topBar, title, iconMenu, iconSearch) = createRefs()
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.08f)
            .background(SecondaryColor)
            .constrainAs(topBar) {
                top.linkTo(parent.top)
            })
        Text(
            text = "WhatsApp",
            fontFamily = RobotoBold,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(topBar.start, margin = 20.dp)
                bottom.linkTo(topBar.bottom, margin = 18.dp)
            }
        )
        IconButton(onClick = { }, modifier = Modifier.constrainAs(iconMenu) {
            end.linkTo(topBar.end)
            top.linkTo(title.top)
            bottom.linkTo(title.bottom)
        }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "menu",
                tint = Color.White
            )
        }
        IconButton(onClick = { }, modifier = Modifier.constrainAs(iconSearch) {
            end.linkTo(iconMenu.start)
            top.linkTo(title.top)
            bottom.linkTo(title.bottom)
        }) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "search",
                tint = Color.White
            )
        }
    }
}