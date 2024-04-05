package com.clone.whatsapp.domain.helper

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp


@Composable
fun ContextMenu(isExpanded: Boolean, dpOffset: DpOffset, height: Dp, onDismissRequest: () -> Unit) {
    DropdownMenu(expanded = isExpanded, onDismissRequest = {
        onDismissRequest()
    }, offset = dpOffset.copy(y = dpOffset.y-height)) {
        (1..6).forEachIndexed { index, i ->
            DropdownMenuItem(text = { Text(text = "test $i") }, onClick = { })
        }

    }


}