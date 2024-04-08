package com.clone.whatsapp.presantation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.clone.whatsapp.domain.helper.TopBar

@Preview(showSystemUi = true)
@Composable
private fun StarredMessage() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        TopBar(title = "Starred Message")
    }
}