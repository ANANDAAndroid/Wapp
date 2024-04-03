package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.clone.whatsapp.R
import com.clone.whatsapp.data.model.ChatModel
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.RobotoRegular

@Preview(showSystemUi = true)
@Composable
fun ChatScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            items(ChatModel.chatContactList) { chatContactDetails ->
                ChatContactItem(chatContactDetails = chatContactDetails)
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ChatContactItem(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 10.dp,
    chatContactDetails: ChatModel.ChatContactDetails
) {
    ConstraintLayout(
        modifier = modifier.height(80.dp)
    ) {
        val (spacerTop, image, title, message, time, unread, spacerBottom, status) = createRefs()
        Spacer(modifier = modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerTop) {
                top.linkTo(parent.top)
            })
        GlideImage(
            model = chatContactDetails.profilePicture,
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(spacerTop.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            contentScale = ContentScale.FillBounds,
            failure = placeholder(androidx.vectordrawable.R.drawable.notification_template_icon_bg),
            loading = placeholder(androidx.vectordrawable.R.drawable.notification_template_icon_bg)
        )
        Text(
            text = chatContactDetails.name, modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top, margin = 5.dp)
                start.linkTo(image.end, margin = 10.dp)
            }, fontFamily = RobotoBold, fontWeight = FontWeight.Bold, fontSize = 16.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )


        Text(
            text = chatContactDetails.message,
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier.constrainAs(message) {
                if (chatContactDetails.sender) {
                    start.linkTo(status.end, margin = 1.dp)
                } else {
                    start.linkTo(title.start)
                }

                end.linkTo(parent.end, margin = 30.dp)
                bottom.linkTo(image.bottom, margin = 5.dp)
                width = Dimension.fillToConstraints
            },
            fontFamily = RobotoRegular,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
        if (chatContactDetails.sender) {
            Icon(
                painter = painterResource(
                    id = when {
                        chatContactDetails.read -> R.drawable.read
                        chatContactDetails.delivered -> R.drawable.delivered
                        else -> {
                            R.drawable.undelivered
                        }
                    }
                ),
                contentDescription = "status",
                tint = Color.Unspecified,
                modifier = Modifier.constrainAs(status) {
                    start.linkTo(title.start)
                    bottom.linkTo(message.bottom)
                    width = Dimension.fillToConstraints
                })
        }
        Text(
            text = "2:00 pm",
            modifier = Modifier.constrainAs(time) {
                end.linkTo(parent.end, margin = 10.dp)
                top.linkTo(title.top, margin = 10.dp)
                bottom.linkTo(title.bottom)
            },
            fontFamily = RobotoBold,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = colorResource(
                id = R.color.message_color
            )
        )

        if (chatContactDetails.unreadMessage > 0) {
            Text(
                text = chatContactDetails.unreadMessage.toString(),
                modifier = Modifier
                    .constrainAs(unread) {
                        end.linkTo(time.end)
                        top.linkTo(message.top, margin = 10.dp)
                        bottom.linkTo(message.bottom)
                    }
                    .background(
                        colorResource(id = R.color.unread_message_count_bg_color),
                        CircleShape
                    )
                    .defaultMinSize(minHeight = 20.dp, minWidth = 20.dp)
                    .wrapContentSize(Alignment.Center)
                    .padding(horizontal = 5.dp),
                fontFamily = RobotoBold,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
            )
        }


        Spacer(modifier = modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerBottom) {
                top.linkTo(unread.bottom)
            })

    }
}