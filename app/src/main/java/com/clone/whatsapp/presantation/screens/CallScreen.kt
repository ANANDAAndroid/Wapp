package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.clone.whatsapp.R
import com.clone.whatsapp.data.model.CallModel
import com.clone.whatsapp.data.model.CallModel.Companion.callContactDetails
import com.clone.whatsapp.domain.helper.compareDate2
import com.clone.whatsapp.domain.helper.getMonth
import com.clone.whatsapp.domain.helper.getTime2
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.SecondaryColor

@Preview(showSystemUi = true)
@Composable
fun CallScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp)
    ) {
        val (action) = createRefs()
        LazyColumn {
            items(callContactDetails) {
                CallContactItem(callContactDetails = it)
            }
        }

        SmallFloatingActionButton(
            onClick = { },
            shape = CircleShape,
            containerColor = SecondaryColor,
            modifier = Modifier.constrainAs(action) {
                bottom.linkTo(parent.bottom, margin = 30.dp)
                end.linkTo(parent.end, margin = 30.dp)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_add_call),
                contentDescription = "action button",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(50.dp)
                    .padding(bottom = 8.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun CallContactItem(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 10.dp,
    callContactDetails: CallModel.CallContactDetails
) {
    ConstraintLayout(
        modifier = modifier.height(80.dp)
    ) {
        val (spacerTop, image, title, message, call, spacerBottom, status) = createRefs()
        Spacer(modifier = modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerTop) {
                top.linkTo(parent.top)
            })
        GlideImage(
            model = callContactDetails.profilePicture,
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(spacerTop.bottom)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            contentScale = ContentScale.FillBounds,
            failure = placeholder(androidx.core.R.drawable.notification_template_icon_bg),
            loading = placeholder(androidx.core.R.drawable.notification_template_icon_bg)
        )
        Text(
            text = callContactDetails.name, modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top, margin = 4.dp)
                start.linkTo(image.end, margin = 10.dp)
            }, fontFamily = RobotoBold, fontWeight = FontWeight.Bold, fontSize = 16.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )


        Text(
            text = when {
                callContactDetails.date.compareDate2() < 1440 -> "Today, ${callContactDetails.date.getTime2()}"
                else -> {
                    callContactDetails.date.getMonth() + "," + callContactDetails.date.getTime2()
                }
            },
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier.constrainAs(message) {
                start.linkTo(status.end, margin = 5.dp)
                bottom.linkTo(status.bottom)
                top.linkTo(status.top)
            },
            fontFamily = RobotoRegular,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.call_time_text_color),
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
        Icon(
            painter = painterResource(
                id = when {
                    callContactDetails.callType1 == 1 -> R.drawable.outgoing_call
                    else -> R.drawable.incoming_call
                }

            ),
            contentDescription = "status",
            tint = Color.Unspecified,
            modifier = Modifier.constrainAs(status) {
                start.linkTo(title.start)
                bottom.linkTo(image.bottom, margin = 11.dp)
            })
        Icon(
            painter = painterResource(
                id = when {
                    callContactDetails.callType2 == 0 -> R.drawable.icon_call
                    else -> {
                        R.drawable.icon_video
                    }
                }
            ),
            contentDescription = "status",
            tint = Color.Unspecified,
            modifier = Modifier.constrainAs(call) {
                top.linkTo(message.top)
                bottom.linkTo(message.top)
                end.linkTo(parent.end, margin = 10.dp)
            })

        Spacer(modifier = modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerBottom) {
                top.linkTo(image.bottom)
            })

    }

}