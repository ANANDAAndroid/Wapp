package com.clone.whatsapp.domain.helper

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.clone.whatsapp.R

@Preview(showBackground = true)
@Composable
fun Loader(modifier: Modifier = Modifier) {
    val abc = rememberInfiniteTransition(label = "test")
    val angle = abc.animateFloat(
        initialValue = 1f, targetValue = 360f, animationSpec = infiniteRepeatable(
            tween(1000, easing = LinearEasing), repeatMode = RepeatMode.Restart
        ), label = "test"
    )
    Dialog(onDismissRequest = { }) {
        Box(
            modifier = modifier
                .size(80.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {

            AnimatedContent(targetState = true, label = "test") {
                if (it) {
                    Image(
                        painter = painterResource(id = R.drawable.loader_image),
                        contentDescription = "",
                        modifier = Modifier.rotate(angle.value).size(50.dp)
                    )
                }
            }


        }

    }


}