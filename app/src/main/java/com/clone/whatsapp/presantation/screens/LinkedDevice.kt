package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.TopBar
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.RobotoSemiBold
import com.clone.whatsapp.presantation.SecondaryColor


@Composable
fun LinkedDevice(onBack:() -> Unit,onClick: () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, image, text, button, divider, image2, text2) = createRefs()
        TopBar(modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top)
        }, title = "Linked devices") {
            onBack()
        }
        Image(
            painter = painterResource(id = R.drawable.image_linked_device),
            contentDescription = "linked device",
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .constrainAs(image) {
                    top.linkTo(topBar.bottom, margin = (-15).dp)
                }
        )
        Text(
            text = "Use WhatsAPP on other\ndevices",
            textAlign = TextAlign.Center,
            fontFamily = RobotoMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(image.bottom, margin = (-15).dp)
                })

        Button(
            onClick = { onClick() },
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors()
                .copy(containerColor = SecondaryColor, contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .constrainAs(button) {
                    top.linkTo(text.bottom, margin = 20.dp)
                }) {
            Text(
                text = "LINK A DEVICE",
                fontFamily = RobotoSemiBold,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(divider) {
                    top.linkTo(button.bottom, margin = 30.dp)
                }, color = colorResource(id = R.color.divider_color),
            thickness = 8.dp
        )
        Image(
            modifier = Modifier.constrainAs(image2) {
                top.linkTo(text2.top)
                bottom.linkTo(text2.bottom)
                start.linkTo(parent.start, margin = 20.dp)
            },
            painter = painterResource(id = R.drawable.image_multi_device_beta),
            contentDescription = ""
        )

        Column(modifier = Modifier.constrainAs(text2) {
            top.linkTo(divider.bottom, margin = 30.dp)
            start.linkTo(image2.end, margin = 20.dp)
        }, verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Multi-device beta",
                fontFamily = RobotoRegular,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "Use up to 4 devices without keeping your\nphone online. Tap to learn more.",
                fontFamily = RobotoRegular,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.multi_device_sub_text_color),
                fontSize = 14.sp,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
            )
        }
    }
}