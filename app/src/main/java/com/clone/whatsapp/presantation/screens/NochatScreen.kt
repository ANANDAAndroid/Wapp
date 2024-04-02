package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoSemiBold

@Preview(showSystemUi = true)
@Composable
 fun NoChatScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (image, button, text) = createRefs()
        val createGuidelineFromTop = createGuidelineFromTop(0.32f)
        val createGuidelineFromBottom = createGuidelineFromBottom(0.25f)
        Image(
            painter = painterResource(id = R.drawable.no_chat_background),
            contentDescription = "no_chat",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.no_chat_image_color),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
                .constrainAs(image) {
                    top.linkTo(createGuidelineFromTop)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Box(modifier = Modifier.background(color = Color.White, shape = CircleShape)) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = "done",
                    tint = colorResource(id = R.color.no_chat_image_color)
                )
            }
        }

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(createGuidelineFromBottom)
            },
            colors = ButtonDefaults.buttonColors()
                .copy(
                    containerColor = colorResource(id = R.color.no_chat_image_color),
                    contentColor = Color.White
                )
        ) {
            Text(
                text = "Start Chatting",
                fontFamily = RobotoSemiBold,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        Text(
            text = "You haven’t chat yet",
            fontFamily = RobotoMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            modifier = Modifier.constrainAs(text) {
                bottom.linkTo(button.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}