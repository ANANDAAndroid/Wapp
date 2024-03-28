package com.clone.whatsapp.presantation.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.OTPView
import com.clone.whatsapp.domain.utils.annotatedString
import com.clone.whatsapp.presantation.RobotoMedium
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.viewmodels.OtpScreenViewModel


@Composable
fun OTPScreen(
    phoneNumber: String?,
    viewModel: OtpScreenViewModel = hiltViewModel(),
    context: Context = LocalContext.current,
    onBack:()->Unit,
    navigate:()->Unit
) {
    val focusManager = LocalFocusManager.current
    val annotatedString = remember { mutableStateOf(AnnotatedString("")) }
    var verifyEnable by remember { mutableStateOf(false) }
    val errorShow by remember { mutableStateOf(false) }
    var otp by remember { mutableStateOf("") }
    LaunchedEffect(key1 = viewModel.time) {
        annotatedString.value = context annotatedString viewModel.time
    }

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }) {

        val (arrow, heading, row, button,error) = createRefs()
        val createGuideLine = createGuidelineFromTop(0.02f)
        val createGuidelineFromBottom = createGuidelineFromBottom(0.1f)

        IconButton(onClick = {onBack() }, modifier = Modifier.constrainAs(arrow) {
            top.linkTo(createGuideLine)
            start.linkTo(parent.start, margin = 10.dp)
        }) {
            Icon(painter = painterResource(id = R.drawable.back_arrow), contentDescription = "back")
        }

        Text(text = "Enter OTP Code", modifier = Modifier.constrainAs(heading) {
            top.linkTo(arrow.top)
            bottom.linkTo(arrow.bottom)
            start.linkTo(arrow.end)
        }, color = Color.Black, fontFamily = RobotoMedium, fontSize = 24.sp)

        Column(
            modifier = Modifier.constrainAs(row) {
                top.linkTo(heading.bottom)
                bottom.linkTo(button.top)
                start.linkTo(parent.start, margin = 30.dp)
                end.linkTo(parent.end, margin = 30.dp)
                width = Dimension.fillToConstraints
            }, verticalArrangement = Arrangement.spacedBy(70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Code has been send to +91 $phoneNumber", fontFamily = RobotoRegular, fontSize = 12.sp)

            OTPView(value = otp){
                if (it.length <= 4) otp = it
            }

            Text(text = annotatedString.value, fontFamily = RobotoRegular, fontSize = 12.sp)


        }
        Button(onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = colorResource(id = R.color.disable_button_color)
            ),
            shape = RoundedCornerShape(50.dp),
            enabled = verifyEnable,
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(createGuidelineFromBottom)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    width = Dimension.fillToConstraints
                }
                .height(50.dp)) {
            Text(
                text = "Verify",
                fontFamily = RobotoMedium,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        if (!otp.contentEquals("1234")){
            ErrorView(modifier = Modifier.constrainAs(error){
                top.linkTo(row.top, margin = 170.dp)
                start.linkTo(row.start)
                end.linkTo(row.end)
                width= Dimension.fillToConstraints
            })
        }else{
            verifyEnable=true
        }





    }

}

@Preview(showSystemUi = true)
@Composable
fun ErrorView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.error_bg_color),
                shape = RoundedCornerShape(20.dp)
            )
            .padding( horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.error), contentDescription = "error", tint = Color.Red)
        Text(
            text = "Invalid password",
            color = colorResource(id = R.color.error_text_color),
            fontFamily = RobotoRegular,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 5.dp)
        )


    }
}