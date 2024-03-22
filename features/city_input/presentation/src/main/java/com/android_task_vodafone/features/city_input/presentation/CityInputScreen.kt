package com.android_task_vodafone.features.city_input.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@androidx.compose.runtime.Composable
fun CityInputScreen(
    modifier: Modifier = Modifier,
    cityInputState: CityInputState,
    onValueChange: (cityName: String) -> Unit,
    onConirmBtnClick: () -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(horizontal = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = cityInputState.cityName,
            onValueChange = { onValueChange(it) },
            label = { Text(text = stringResource(R.string.city_name)) }

        )
        Spacer(modifier = modifier.height(20.dp))
        Button(
            modifier = modifier.fillMaxWidth().height(50.dp),
            onClick = onConirmBtnClick,
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Confirm", textAlign = TextAlign.Center, fontSize = 16.sp, fontWeight = FontWeight.Bold)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCityInputScreen() {
    CityInputScreen(cityInputState = CityInputState(), onValueChange = {}) {

    }
}