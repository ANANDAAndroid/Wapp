package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.TopBar
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.SecondaryColor


@Composable
 fun StarredMessage(onBack:() -> Unit) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, column) = createRefs()
        TopBar(title = "Starred messages", modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top)
        }){
            onBack()
        }

        Column(
            modifier = Modifier.constrainAs(column) {
                top.linkTo(topBar.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        SecondaryColor
                    )
                    .padding(30.dp)
                    .size(30.dp)
            )
            Text(
                text = "Tap and hold on any message\nin any chat to star it, so you\ncan easily find it later.",
                textAlign = TextAlign.Center,
                fontFamily = RobotoRegular,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

