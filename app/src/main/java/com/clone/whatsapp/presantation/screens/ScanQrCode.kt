package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.TopBar
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.RobotoSemiBold
import com.clone.whatsapp.presantation.SecondaryColor


@Composable
fun ScanQrCode(onBack:() -> Unit) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, image, text) = createRefs()
        TopBar(modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top)
        }, title = "Scan QR code"){
            onBack()
        }

        Text(
            modifier = Modifier
                .background(color = colorResource(id = R.color.scan_qr_text_bg_color))
                .fillMaxWidth()
                .padding(vertical = 30.dp)
                .constrainAs(text) {
                    top.linkTo(topBar.bottom)
                },
            text = "To use WhatsApp web, go to\nweb.whatsapp.com on your computer.",
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.scan_qr_text_color),
            fontFamily = RobotoRegular, fontWeight = FontWeight.Normal, fontSize = 16.sp
        )
        Column(
            modifier = Modifier
                .size(330.dp)
                .background(colorResource(id = R.color.scan_qr_bg_color))
                .constrainAs(image) {
                    top.linkTo(topBar.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                },
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.image_scan),
                contentDescription = "scan",
                modifier = Modifier.width(400.dp).size(150.dp)
            )
            Button(
                onClick = { },
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors()
                    .copy(containerColor = SecondaryColor, contentColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "OK",
                    fontFamily = RobotoSemiBold,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }

        }
    }
}