package com.clone.whatsapp.presantation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.utils.Route
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.TypographyForButton


@Composable
fun WelcomeScreen(context: Context = LocalContext.current, navigate: () -> Unit) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (heading, image, spacer1, spacer2, spanText, button, footer) = createRefs()
        val createGuidelineFromTop = createGuidelineFromTop(0.07f)
        val createGuidelineFromTop2 = createGuidelineFromTop(0.7f)
        val createGuidelineFromBottom = createGuidelineFromBottom(0.01f)
        Text(
            text = "Welcome to WhatsApp",
            modifier = Modifier
                .constrainAs(heading) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(createGuidelineFromTop)
                },
            fontSize = 25.sp,
            fontFamily = RobotoBold,
            color = colorResource(id = R.color.black)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.08f)
            .constrainAs(spacer1) {
                top.linkTo(heading.bottom)
            })
        Image(painter = painterResource(id = R.drawable.image1),
            contentDescription = "image",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(spacer1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(200.dp)
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.08f)
            .constrainAs(spacer2) {
                top.linkTo(image.bottom)
            }
        )

        val an1 = "Privacy Policy."
        val an2 = "Teams of Service."
        val annotatedString = buildAnnotatedString {
            append("Read our ")
            withStyle(SpanStyle(color = colorResource(id = R.color.span_text_color))) {
                pushStringAnnotation(an1, annotation = an1)
                append(an1)
            }
            append(" Tap “Agree and continue” to accept the ")
            withStyle(SpanStyle(color = colorResource(id = R.color.span_text_color))) {
                pushStringAnnotation(an2, annotation = an2)
                append(an2)
            }
        }
        ClickableText(modifier = Modifier
            .constrainAs(spanText) {
                top.linkTo(spacer2.bottom)
            }
            .padding(horizontal = 28.dp),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = RobotoRegular,
                fontSize = 12.sp
            ),
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { span ->
                    Toast.makeText(context, span.item, Toast.LENGTH_SHORT).show()
                }
            })

        Button(onClick = {
            navigate()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.button_color),
                contentColor = colorResource(
                    id = R.color.black
                )
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(createGuidelineFromTop2)
                start.linkTo(heading.start)
                end.linkTo(heading.end)
                width = Dimension.fillToConstraints
            }) {
            Text(text = "AGREE AND CONTINUE", style = TypographyForButton.labelMedium)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .constrainAs(footer) {
                    bottom.linkTo(createGuidelineFromBottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
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