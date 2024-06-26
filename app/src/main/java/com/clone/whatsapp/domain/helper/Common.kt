package com.clone.whatsapp.domain.helper

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.SimpleDateFormat
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Locale

class CustomVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Make the string XXX-XXX-XXX
        val trimmed = text.text
        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            if (i % 3 == 2 && i != 8) output += " "
        }


        /**
         * The offset works such that the translator ignores hyphens. Conversions
         * from original to transformed text works like this
        - 3rd character in the original text is the 4th in the transformed text
        - The 6th character in the original becomes the 8th
        In reverse, the conversion is such that
        - 10th Character in transformed becomes the 8th in original
        - 4th in transformed becomes 3rd in original
         */

        val cameroonNumberTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                // [offset [0 - 2] remain the same]
                if (offset <= 2) return offset
                // [3 - 5] transformed to [4 - 6] respectively
                if (offset <= 5) return offset + 1
                // [6 - 8] transformed to [8 - 10] respectively
                if (offset <= 9) return offset + 2
                return 12
            }

            override fun transformedToOriginal(offset: Int): Int {

                if (offset <= 2) return offset
                if (offset <= 6) return offset - 1
                if (offset <= 10) return offset - 2
                return 10

            }

        }

        return TransformedText(
            AnnotatedString(output),
            cameroonNumberTranslator
        )

    }

}

fun String.maskPhoneNumber(): String {
    val phone = StringBuilder(this)
    for (i in 2..7) {
        phone.setCharAt(i, '*')
    }
    return phone.toString()
}

fun Date.get_Time(): String {
    return SimpleDateFormat("h:mm a", Locale.getDefault()).format(this)
}

fun getDate(): String {
    return SimpleDateFormat("d/MM/yyyy", Locale.getDefault()).format(Date())
}

fun String.compareDate(): Int {
    val sdf = SimpleDateFormat("d/MM/yyyy", Locale.getDefault())
    val date = sdf.parse(this)
    val todayDate = sdf.parse(SimpleDateFormat("d/MM/yyyy", Locale.getDefault()).format(Date()))
    return todayDate?.let { date1 ->
        date?.let { date2 ->
            ChronoUnit.DAYS.between(date2.toInstant(), date1.toInstant()).toInt()
        }
    } ?: 0
}

fun String.compareDate2(): Int {
    println(Date())
    val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.getDefault())
    val date = sdf.parse(this)
    val todayDate = sdf.parse(SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.getDefault()).format(Date()))
    return todayDate?.let { date1 ->
        date?.let { date2 ->
            ChronoUnit.MINUTES.between(date2.toInstant(), date1.toInstant()).toInt()
        }
    } ?: 0
}
fun String.getTime2(): String {
    val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.getDefault())
    val date = sdf.parse(this)
    return date?.get_Time() ?:""
}
fun String.getMonth(): String? {
    val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.getDefault())
    val date = sdf.parse(this)
    return date?.let { SimpleDateFormat("MMMM dd", Locale.getDefault()).format(it) }
}
