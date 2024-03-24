package com.android_task_vodafone.features.city_input.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityInputScreen(
    modifier: Modifier = Modifier,
    onConfirmBtnClick: (searchQuery: String) -> Unit,
) {
    var searchQuery by remember { mutableStateOf("") }

    Box(
        Modifier
            .background(Color.Transparent)
            .shadow(5.dp, MaterialTheme.shapes.large),
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),

            shape = MaterialTheme.shapes.large,
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text(text = stringResource(R.string.city_name)) },
            maxLines = 1,
            keyboardActions = KeyboardActions(
                onSearch = { onConfirmBtnClick(searchQuery) }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
            ),
            trailingIcon = {
                FilledIconButton(
                    modifier = modifier.size(25.dp),
                    onClick = { onConfirmBtnClick(searchQuery) },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.3f
                        )
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        Modifier.size(17.dp),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }

        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewCityInputScreen() {
    CityInputScreen(
        onConfirmBtnClick = {},
    )
}