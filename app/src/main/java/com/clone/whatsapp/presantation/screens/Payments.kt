package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.TopBar
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.RobotoSemiBold
import com.clone.whatsapp.presantation.SecondaryColor

@Preview(showSystemUi = true)
@Composable
fun Payments() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topBar, history, page, text, divider1, method, column, divider2, ask, bhim, action) = createRefs()
        TopBar(title = "Payments", modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top)
        }) {

        }

        Text(text = "History", modifier = Modifier.constrainAs(history) {
            top.linkTo(topBar.bottom, margin = 5.dp)
            start.linkTo(parent.start, margin = 15.dp)
        }, fontFamily = RobotoSemiBold, color = SecondaryColor, fontSize = 12.sp)

        Image(painter = painterResource(id = R.drawable.image_page),
            contentDescription = "page",
            modifier = Modifier
                .fillMaxWidth()
                .size(60.dp)
                .constrainAs(page) {
                    top.linkTo(history.bottom, margin = 10.dp)
                })
        Text(text = "No payment history",
            textAlign = TextAlign.Center,
            fontFamily = RobotoRegular,
            fontSize = 12.sp,
            color = colorResource(id = R.color.no_payment_color),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(page.bottom, margin = 10.dp)
                })

        HorizontalDivider(modifier = Modifier.constrainAs(divider1) {
            top.linkTo(text.bottom, margin = 30.dp)
        }, thickness = 8.dp, color = colorResource(id = R.color.divider_color))

        Text(text = "Payment method", modifier = Modifier.constrainAs(method) {
            top.linkTo(divider1.bottom, margin = 15.dp)
            start.linkTo(history.start)
        }, fontFamily = RobotoSemiBold, color = SecondaryColor, fontSize = 12.sp)
        Column(modifier = Modifier.constrainAs(column) {
            top.linkTo(method.bottom)
            start.linkTo(method.start)
        }) {
            Item(icon1 = painterResource(id = R.drawable.icon_protect), desc1 = annotatedString)
            Item(icon2 = painterResource(id = R.drawable.icon_add), desc2 = "Add payment method")

        }
        HorizontalDivider(modifier = Modifier.constrainAs(divider2) {
            top.linkTo(column.bottom, margin = 5.dp)
        }, thickness = 8.dp, color = colorResource(id = R.color.divider_color))
        Item(modifier = Modifier.constrainAs(ask) {
            top.linkTo(divider2.bottom)
            start.linkTo(method.start)
        }, icon2 = painterResource(id = R.drawable.icon_question), desc2 = "Help")

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(40.dp)
                .constrainAs(bhim) {
                    top.linkTo(ask.bottom, margin = 20.dp)
                },
            painter = painterResource(id = R.drawable.image_bhim_upi),
            contentDescription = "bhim"
        )

        ExtendedFloatingActionButton(
            onClick = { },
            shape = RoundedCornerShape(40.dp),
            containerColor = SecondaryColor,
            modifier = Modifier.constrainAs(action) {
                bottom.linkTo(parent.bottom, margin = 30.dp)
                end.linkTo(parent.end, margin = 30.dp)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_doller),
                contentDescription = "action button",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(50.dp)
                    .wrapContentSize(Alignment.Center)
            )
            Text(text = "NEW PAYMENT", color = Color.White, fontFamily = RobotoMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Item(
    modifier: Modifier = Modifier,
    desc1: AnnotatedString = AnnotatedString(""),
    icon1: Painter? = null,
    icon2: Painter? = null,
    desc2: String = ""
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon1 ?: icon2!!, contentDescription = "protect", tint = Color.Unspecified
        )

        if (desc2.isBlank()) {
            Text(text = desc1, fontFamily = RobotoRegular, fontSize = 12.sp)
        } else {
            Text(text = desc2, fontFamily = RobotoRegular, fontSize = 12.sp, color = Color.Black)
        }
    }

}

val annotatedString = buildAnnotatedString {
    withStyle(style = SpanStyle(color = Color(0xFF687176))) {
        append("To protect your security. WhatsApp does not\nstore your upi pin or full bank account number.")
    }

    withStyle(style = SpanStyle(color = Color(0xFF32ADE4))) {
        append("\nLearn more")
    }
}