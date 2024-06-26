package com.clone.whatsapp.presantation

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.clone.whatsapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val TypographyForButton = Typography(
    labelMedium = TextStyle(
        fontFamily = RobotoRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black
    )
)
val TypographyForButton2 = Typography(
    labelMedium = TextStyle(
        fontFamily = RobotoSemiBold,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = Color.Black
    )
)
