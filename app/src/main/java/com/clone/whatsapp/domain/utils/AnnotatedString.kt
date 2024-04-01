package com.clone.whatsapp.domain.utils

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.clone.whatsapp.R

infix fun Context.annotatedString(text:String) = buildAnnotatedString {
    append("Resend Code in ")
    withStyle(style = SpanStyle(color = Color(getColor(R.color.button_color)))){
        append(text)
    }
    append(" s")
}