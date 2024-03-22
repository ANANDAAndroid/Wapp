package com.clone.whatsapp.presantation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.Dropdown
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular

@Preview(showSystemUi = true)
@Composable
fun PhoneNumberScreen(context: Context = LocalContext.current) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (heading, moreVert, spanText, dropdown) = createRefs()
        val createGuidelineFromTop = createGuidelineFromTop(0.07f)
        val createGuidelineFromTop2 = createGuidelineFromTop(0.12f)
        Text(
            text = "Enter your phone number",
            fontSize = 18.sp,
            fontFamily = RobotoMedium,
            color = Color.Black,
            modifier = Modifier.constrainAs(heading) {
                top.linkTo(createGuidelineFromTop)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        IconButton(onClick = {
            Toast.makeText(context, "Item clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier
            .constrainAs(moreVert) {
                top.linkTo(heading.top)
                bottom.linkTo(heading.bottom)
                start.linkTo(heading.end)
            }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "more vert")
        }

        val an1 = "What’s my number?"
        val annotatedString = buildAnnotatedString {
            append("WhatsApp will need to verify your phone number. ")
            withStyle(SpanStyle(color = colorResource(id = R.color.span_text_color))) {
                pushStringAnnotation(an1, annotation = an1)
                append(an1)
            }
        }
        ClickableText(modifier = Modifier
            .constrainAs(spanText) {
                top.linkTo(createGuidelineFromTop2)
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
        Dropdown(modifier = Modifier
            .constrainAs(dropdown) {
                top.linkTo(spanText.bottom)
                start.linkTo(heading.start)
                end.linkTo(heading.end)
                width = Dimension.fillToConstraints
            }
            .padding(top = 50.dp))
    }
}