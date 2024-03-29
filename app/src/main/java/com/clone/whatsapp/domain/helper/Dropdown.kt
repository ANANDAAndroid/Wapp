package com.clone.whatsapp.domain.helper

import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.clone.whatsapp.R
import com.clone.whatsapp.domain.utils.Constant
import com.clone.whatsapp.presantation.RobotoRegular


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(
    modifier: Modifier,
    countryList: List<Constant.Country>,
    onItemClick: (String) -> Unit
) {
    var selectedValue by rememberSaveable { mutableStateOf(countryList[0].name) }
    var expanded by rememberSaveable { mutableStateOf(false) }

    ExposedDropdownMenuBox(modifier = modifier, expanded = expanded, onExpandedChange = {
        expanded = !expanded

    }) {
        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedValue,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            placeholder = { Text(text = "Country") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            shape = RectangleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = RobotoRegular,
                fontSize = 16.sp
            )
        )

        ExposedDropdownMenu(
            modifier = Modifier
                .exposedDropdownSize(matchTextFieldWidth = true)
                .fillMaxHeight(0.8f),
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            countryList.forEach { country ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = country.name, style = TextStyle(
                                fontFamily = RobotoRegular,
                                fontSize = 16.sp
                            )
                        )
                    },
                    onClick = {
                        selectedValue = country.name
                        onItemClick(country.code)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }

    }

}