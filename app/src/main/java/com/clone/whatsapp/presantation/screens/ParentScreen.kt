package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.helper.ContextMenu
import com.clone.whatsapp.domain.utils.Constant.menuListCall
import com.clone.whatsapp.domain.utils.Constant.menuListChat
import com.clone.whatsapp.domain.utils.Constant.menuListStatus
import com.clone.whatsapp.domain.utils.Constant.tabList
import com.clone.whatsapp.presantation.RobotoBold
import com.clone.whatsapp.presantation.SecondaryColor


@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun ParentScreen() {


    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabsPadding by remember { mutableStateOf(12.dp) }
    val pagerState = rememberPagerState { tabList.size }
    val density = LocalDensity.current
    var heightOffset by remember { mutableStateOf(0.dp) }
    var widthOffset by remember { mutableStateOf(0.dp) }




    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .onSizeChanged {
            heightOffset = with(density) { it.height.toDp() }
            widthOffset = with(density) { it.width.toDp() }
        }
    ) {

        val (topBar, title, iconMenu, iconSearch, tab, camera, pager) = createRefs()
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.06f)
            .background(SecondaryColor)
            .constrainAs(topBar) {
                top.linkTo(parent.top)
            })
        Text(
            text = "WhatsApp",
            fontFamily = RobotoBold,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(topBar.start, margin = 20.dp)
                bottom.linkTo(topBar.bottom, margin = 8.dp)
            }
        )
        IconButton(
            onClick = {
                expanded = true
            }, modifier = Modifier
                .constrainAs(iconMenu) {
                    end.linkTo(topBar.end)
                    top.linkTo(title.top)
                    bottom.linkTo(title.bottom)
                }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "menu",
                tint = Color.White
            )
        }
        IconButton(onClick = { }, modifier = Modifier.constrainAs(iconSearch) {
            end.linkTo(iconMenu.start)
            top.linkTo(title.top)
            bottom.linkTo(title.bottom)
        }) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "search",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .background(SecondaryColor)
                .constrainAs(tab) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }, contentAlignment = Alignment.Center
        ) {


            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth(0.80f)
                    .padding(start = 15.dp),
                indicator = { tabPositions ->
                    if (selectedTab < tabPositions.size) {
                        TabRowDefaults.SecondaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                            color = Color.White,
                            height = (1.5).dp
                        )
                    }
                },
                divider = {
                    HorizontalDivider(color = Color.Transparent)
                }) {
                tabList.forEachIndexed { index, tabText ->
                    when (index) {
                        0 -> {
                            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = tabsPadding)

                                ) {
                                    Text(
                                        text = tabText.title,
                                        fontFamily = RobotoBold,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    )

                                    Box(
                                        modifier = Modifier
                                            .size(18.dp)
                                            .background(
                                                color = Color.White,
                                                shape = CircleShape
                                            ),
                                        contentAlignment = Alignment.Center


                                    ) {
                                        Text(
                                            text = "1",
                                            color = colorResource(id = R.color.chat_count_color),

                                            fontFamily = RobotoBold,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp,
                                            style = TextStyle(
                                                platformStyle = PlatformTextStyle(
                                                    includeFontPadding = false
                                                )
                                            )
                                        )
                                    }
                                }
                            }
                        }

                        1 -> {
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index }) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = tabsPadding)

                                ) {
                                    Text(
                                        text = tabText.title,
                                        fontFamily = RobotoBold,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    )
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = Color.White,
                                                shape = CircleShape
                                            )
                                            .size(5.dp)
                                    )
                                }
                            }
                        }

                        2 -> {
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index }) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = tabsPadding)

                                ) {
                                    Text(
                                        text = tabText.title,
                                        fontFamily = RobotoBold,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }

                }


            }
        }

        LaunchedEffect(key1 = pagerState.currentPage, key2 = pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) {
                selectedTab = pagerState.currentPage
            }

        }

        LaunchedEffect(key1 = selectedTab) {
            pagerState.animateScrollToPage(selectedTab)
        }


        HorizontalPager(state = pagerState, modifier = Modifier
            .fillMaxWidth()
            .constrainAs(pager) {
                top.linkTo(tab.bottom)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            }) {

            when (it) {
                0 -> {

                    ChatScreen()
                }

                1 -> {
                    StatusScreen()
                }

                2 -> {
                    CallScreen()
                }
            }

        }

        IconButton(onClick = { }, modifier = Modifier.constrainAs(camera) {
            start.linkTo(parent.start)
            top.linkTo(tab.top)
            bottom.linkTo(tab.bottom)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.camera_solid_2),
                contentDescription = "camera",
                tint = Color.Unspecified
            )
        }
    }
    ContextMenu(
        menuList = when (pagerState.currentPage) {
            0 -> menuListChat
            1 -> menuListStatus
            else -> { menuListCall }
        },
        isExpanded = expanded,
        density = density,
        parentHeight = heightOffset,
        parentWidth = widthOffset,
        onDismissRequest = { expanded = false }) {

    }
}