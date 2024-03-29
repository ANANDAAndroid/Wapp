package com.clone.whatsapp.presantation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.CustomVisualTransformation
import com.clone.whatsapp.domain.helper.Dropdown
import com.clone.whatsapp.domain.helper.maskPhoneNumber
import com.clone.whatsapp.domain.utils.Constant.countryList
import com.clone.whatsapp.domain.utils.Route
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.TypographyForButton2


@Composable
fun PhoneNumberScreen(context: Context = LocalContext.current, navigate: (String) -> Unit) {
    val countryList by rememberSaveable { mutableStateOf(countryList) }
    var phoneNUmber by rememberSaveable { mutableStateOf("") }
    var countrycode by rememberSaveable { mutableStateOf(countryList[0].code) }
    val focusManager = LocalFocusManager.current
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }) {
        val (heading, moreVert, spanText, dropdown, number, code, spacer1, spacer2, spacer3, button, text) = createRefs()
        val createGuidelineFromTop = createGuidelineFromTop(0.07f)
        val createGuidelineFromTop2 = createGuidelineFromTop(0.12f)
        val createGuidelineFromBottom = createGuidelineFromBottom(0.1f)
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
            .padding(top = 50.dp), countryList = countryList) {
            countrycode = it
        }

        Spacer(
            modifier = Modifier
                .constrainAs(spacer3) {
                    start.linkTo(dropdown.start)
                    end.linkTo(dropdown.end)
                    top.linkTo(dropdown.bottom, margin = (-3).dp)
                    width = Dimension.fillToConstraints
                }
                .height(2.dp)
                .background(color = colorResource(id = R.color.button_color))
        )



        BasicTextField(value = phoneNUmber, onValueChange = {
            if (it.length <= 10 && it.isDigitsOnly()) {
                phoneNUmber = it
            }
        }, modifier = Modifier
            .constrainAs(number) {
                top.linkTo(dropdown.bottom, margin = 10.dp)
                end.linkTo(dropdown.end)
            }
            .width(150.dp),
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = RobotoRegular,
                fontSize = 16.sp
            ), visualTransformation = CustomVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword))



        BasicTextField(
            value = countrycode, onValueChange = {}, modifier = Modifier
                .constrainAs(code) {
                    top.linkTo(number.top)
                    bottom.linkTo(number.bottom)
                    start.linkTo(dropdown.start)
                    width = Dimension.fillToConstraints
                    end.linkTo(number.start, margin = 20.dp)
                }, singleLine = true,
            readOnly = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = RobotoRegular,
                fontSize = 16.sp,
            )
        )
        Spacer(
            modifier = Modifier
                .constrainAs(spacer1) {
                    start.linkTo(number.start)
                    end.linkTo(number.end)
                    top.linkTo(number.bottom, margin = 3.dp)
                    width = Dimension.fillToConstraints
                }
                .height(2.dp)
                .background(color = colorResource(id = R.color.button_color))
        )

        Spacer(
            modifier = Modifier
                .constrainAs(spacer2) {
                    start.linkTo(code.start)
                    end.linkTo(code.end)
                    top.linkTo(code.bottom, margin = 3.dp)
                    width = Dimension.fillToConstraints
                }
                .height(2.dp)
                .background(color = colorResource(id = R.color.button_color))
        )
        Text(text = " Carrier charges may apply", modifier = Modifier.constrainAs(text) {
            top.linkTo(spacer2.bottom, margin = 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }, fontFamily = RobotoRegular, color = Color.Black, fontSize = 12.sp)

        Button(onClick = {

            if (phoneNUmber.length == 10) {
                navigate("${countrycode.removeRange(1,2)} ${phoneNUmber.maskPhoneNumber()}")
            }

        },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.button_color),
                contentColor = colorResource(
                    id = R.color.black
                )
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(createGuidelineFromBottom)
                start.linkTo(heading.start)
                end.linkTo(heading.end)
            }) {
            Text(text = "NEXT", style = TypographyForButton2.labelMedium)
        }


    }
}