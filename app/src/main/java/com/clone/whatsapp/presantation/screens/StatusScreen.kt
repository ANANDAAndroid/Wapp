package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
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
import androidx.constraintlayout.compose.Dimension
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.clone.whatsapp.R
import com.clone.whatsapp.data.model.StatusModel
import com.clone.whatsapp.data.model.StatusModel.Companion.statusContactList
import com.clone.whatsapp.domain.helper.compareDate2
import com.clone.whatsapp.domain.helper.getTime2
import com.clone.whatsapp.presantation.RecentStatusBgColor
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.RobotoRegular
import com.clone.whatsapp.presantation.SecondaryColor
import com.clone.whatsapp.presantation.ViewedStatusBgColor

@Preview(showSystemUi = true)
@Composable
fun StatusScreen() {
    val state = rememberScrollState()

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (contact, write) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
                .padding(start = 5.dp)

        ) {
            MyStatus()
            StatusList(
                modifier = Modifier.padding(top = 15.dp),
                typeOfStatus = "Recent updates",
                borderColor = RecentStatusBgColor,
                statusContactList = statusContactList
            )
            StatusList(
                modifier = Modifier.padding(top = 15.dp),
                typeOfStatus = "Viewed updates",
                borderColor = ViewedStatusBgColor,
                statusContactList = statusContactList
            )
        }

        SmallFloatingActionButton(
            onClick = { },
            shape = CircleShape,
            containerColor = SecondaryColor,
            modifier = Modifier.constrainAs(contact) {
                bottom.linkTo(parent.bottom, margin = 30.dp)
                end.linkTo(parent.end, margin = 30.dp)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.camera_solid_2),
                contentDescription = "action button",
                tint = Color.White,
                modifier = Modifier
                    .size(50.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }

        SmallFloatingActionButton(
            onClick = { },
            shape = CircleShape,
            containerColor = SecondaryColor,
            modifier = Modifier.constrainAs(write) {
                bottom.linkTo(contact.top, margin = 20.dp)
                end.linkTo(contact.end)
                start.linkTo(contact.start)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_write),
                contentDescription = "action button",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(30.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }
    }


}


@Composable
private fun StatusList(
    modifier: Modifier = Modifier,
    typeOfStatus: String,
    borderColor: Color,
    statusContactList: List<StatusModel.StatusContactDetails>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = typeOfStatus,
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier.padding(start = 10.dp, bottom = 15.dp),
            fontFamily = RobotoRegular,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.status_category_text_color),
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )

        repeat(statusContactList.size) {

            when {
                !statusContactList[it].view && typeOfStatus.contentEquals("Recent updates") -> {
                    StatusContact(
                        borderColor = borderColor,
                        statusContactDetails = statusContactList[it]
                    )
                }

                statusContactList[it].view && typeOfStatus.contentEquals("Viewed updates") -> {
                    StatusContact(
                        borderColor = borderColor,
                        statusContactDetails = statusContactList[it]
                    )
                }
            }
        }


    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Preview(showBackground = true)
@Composable
private fun MyStatus(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 15.dp
) {

    ConstraintLayout(modifier = modifier) {
        val (spacerTop, image, title, message, spacerBottom, add) = createRefs()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerTop) {
                top.linkTo(parent.top)
            })
        GlideImage(
            model = "https://cdn.pixabay.com/photo/2016/03/26/22/13/man-1281562_640.jpg",
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(spacerTop.bottom)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            contentScale = ContentScale.FillBounds,
            failure = placeholder(androidx.core.R.color.notification_icon_bg_color),
            loading = placeholder(androidx.core.R.color.notification_icon_bg_color)
        )
        Text(
            text = "My status", modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top, margin = 6.dp)
                start.linkTo(image.end, margin = 10.dp)
            }, fontFamily = RobotoBold, fontWeight = FontWeight.Bold, fontSize = 16.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )


        Text(
            text = "Tap to add status update",
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier.constrainAs(message) {
                start.linkTo(title.start)
                end.linkTo(parent.end, margin = 30.dp)
                bottom.linkTo(image.bottom, margin = 8.dp)
                width = Dimension.fillToConstraints
            },
            fontFamily = RobotoRegular,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.tap_to_add_status_color),
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerBottom) {
                top.linkTo(image.bottom)
            })


        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "add",
            modifier = Modifier
                .constrainAs(add) {
                    bottom.linkTo(image.bottom)
                    end.linkTo(image.end)
                }
                .size(20.dp)
                .background(color = SecondaryColor, shape = CircleShape)
                .border(width = 1.dp, shape = CircleShape, color = Color.Black)
                .clip(CircleShape)
                .clickable {

                })


    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun StatusContact(
    modifier: Modifier = Modifier,
    verticalPadding: Dp = 15.dp,
    borderColor: Color = RecentStatusBgColor,
    statusContactDetails: StatusModel.StatusContactDetails
) {

    ConstraintLayout(modifier = modifier) {
        val (spacerTop, image, title, message, spacerBottom) = createRefs()
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerTop) {
                top.linkTo(parent.top)
            })
        GlideImage(
            model = statusContactDetails.profilePicture,
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .border(width = 1.5.dp, color = borderColor, shape = CircleShape)
                .padding(3.dp)
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(spacerTop.bottom)
                    start.linkTo(parent.start, margin = 10.dp)
                },
            contentScale = ContentScale.FillBounds,
            failure = placeholder(androidx.core.R.color.notification_icon_bg_color),
            loading = placeholder(androidx.core.R.color.notification_icon_bg_color)
        )
        Text(
            text = statusContactDetails.name, modifier = Modifier.constrainAs(title) {
                top.linkTo(image.top, margin = 6.dp)
                start.linkTo(image.end, margin = 10.dp)
            }, fontFamily = RobotoBold, fontWeight = FontWeight.Bold, fontSize = 16.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )


        Text(
            text = when {
                statusContactDetails.date.compareDate2() < 11 -> "${statusContactDetails.date.compareDate2()} minutes ago"
                statusContactDetails.date.compareDate2() in 11..1440 -> "Today, ${statusContactDetails.date.getTime2()}"
                else -> {
                    "Yesterday, ${statusContactDetails.date.getTime2()}"
                }
            },
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier.constrainAs(message) {
                start.linkTo(title.start)
                end.linkTo(parent.end, margin = 30.dp)
                bottom.linkTo(image.bottom, margin = 8.dp)
                width = Dimension.fillToConstraints
            },
            fontFamily = RobotoRegular,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.tap_to_add_status_color),
            fontSize = 14.sp,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(verticalPadding)
            .constrainAs(spacerBottom) {
                top.linkTo(image.bottom)
            })
    }
}