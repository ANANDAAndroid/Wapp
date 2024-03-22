package com.clone.whatsapp.domain.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.utils.Constant.countries

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(modifier: Modifier) {
        var selectedValue by remember { mutableStateOf(countries[0]) }
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(modifier = modifier,expanded = expanded, onExpandedChange = {
            expanded = !expanded

        }) {
            TextField(
                value = selectedValue,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = "Country") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                shape = RectangleShape,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = colorResource(id = R.color.button_color),
                    focusedIndicatorColor = colorResource(id = R.color.button_color)
                )
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                countries.forEach { countryName ->
                    DropdownMenuItem(text = { Text(text = countryName) }, onClick = { selectedValue=countryName })
                }
            }

        }

}