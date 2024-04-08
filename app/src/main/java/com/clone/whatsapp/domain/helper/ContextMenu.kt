package com.clone.whatsapp.domain.helper

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clone.whatsapp.presantation.RobotoRegular


@Composable
fun ContextMenu(
    menuList: List<String>,
    isExpanded: Boolean,
    density: Density,
    parentHeight: Dp,
    parentWidth: Dp,
    onDismissRequest: () -> Unit,
    onItemClick: (String) -> Unit
) {
    var menuWidth by remember { mutableStateOf(0.dp) }
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier.onSizeChanged {
            menuWidth = with(density) { it.width.toDp() }
            println(" menuWidth $menuWidth ")
        },
        offset = DpOffset(x = parentWidth - (menuWidth + 10.dp), y = -parentHeight + 14.dp)
    ) {
        menuList.forEachIndexed { _, i ->
            DropdownMenuItem(text = {
                Text(
                    text = i,
                    fontFamily = RobotoRegular,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    modifier = Modifier.padding(
                        start = 8.dp, end = when {
                            menuList.size == 2 -> 40.dp
                            else -> {
                                30.dp
                            }
                        }
                    )
                )
            }, onClick = {
                onItemClick(i)
                onDismissRequest()
            }, modifier = Modifier.height(
                when {
                    menuList.size == 2 -> 32.dp
                    else -> {
                        45.dp
                    }
                }
            )
            )
        }

    }
}