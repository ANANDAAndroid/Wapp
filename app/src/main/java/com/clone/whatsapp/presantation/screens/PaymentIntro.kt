package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.RobotoSemiBold
import com.clone.whatsapp.presantation.SecondaryColor

@Preview(showSystemUi = true)
@Composable
 fun PaymentIntro() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (heading, image, text, row,bhim,button) = createRefs()
        Text(text = "Payments",
            textAlign = TextAlign.Center,
            fontFamily = RobotoBold,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(heading) {
                    top.linkTo(parent.top, margin = 15.dp)
                })
        Image(
            painter = painterResource(id = R.drawable.image_payment),
            contentDescription = "payment",
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .constrainAs(image) {
                    top.linkTo(heading.bottom, margin = 20.dp)
                }
        )
        Text(text = "Send and recieve money securely, right\nwhere you chat",
            textAlign = TextAlign.Center,
            fontFamily = RobotoMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(image.bottom, margin = 15.dp)
                })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(row) {
                    top.linkTo(text.bottom, margin = 50.dp)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.people),
                contentDescription = "people",
                tint = Color.Unspecified
            )

            Text(
                text = "Crores of people are already using payments on\nwhatsApp.",
                fontFamily = RobotoRegular,
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.image_bhim_upi),
            contentDescription = "bhim", modifier = Modifier.fillMaxWidth().height(40.dp).constrainAs(bhim){
                bottom.linkTo(parent.bottom)
            }
        )
        Button(
            onClick = { },
            shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors()
                .copy(containerColor = SecondaryColor, contentColor = Color.White),
            modifier = Modifier.constrainAs(button){
                bottom.linkTo(bhim.top)
            }
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = "CONTINUE",
                fontFamily = RobotoSemiBold,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }

    }
}