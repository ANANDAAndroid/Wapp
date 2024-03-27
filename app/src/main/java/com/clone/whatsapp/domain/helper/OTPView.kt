package com.clone.whatsapp.domain.helper

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clone.whatsapp.presantation.RobotoRegular

@Preview(showSystemUi = true)
@Composable
fun OTPView(modifier: Modifier = Modifier) {
    var otp by remember { mutableStateOf("") }
    Box(modifier = modifier.fillMaxWidth()) {
        BasicTextField(modifier = Modifier.fillMaxWidth(), value = otp,
            onValueChange = { if (it.length <= 4) otp = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    repeat(4) { index ->
                        val char = when {
                            index >= otp.length -> ""
                            else -> {
                                otp[index].toString()
                            }
                        }
                        Text(
                            text = char, modifier = Modifier
                                .width(70.dp)
                                .height(60.dp)
                                .border(
                                    1.dp, Color.Black,
                                    RoundedCornerShape(14.dp)
                                )
                                .padding(5.dp), fontFamily = RobotoRegular, fontWeight = FontWeight.Normal,
                            fontSize = 24.sp, textAlign = TextAlign.Center
                        )
                    }

                }
            })
    }


}