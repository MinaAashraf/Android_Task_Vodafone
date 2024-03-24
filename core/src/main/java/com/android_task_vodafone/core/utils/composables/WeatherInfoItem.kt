package com.android_task_vodafone.core.utils.composables

import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.android_task_vodafone.core.R
import com.android_task_vodafone.core.utils.ConditionUnit
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.formatDate
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import kotlin.math.roundToInt

@Composable
fun WeatherInfoItem(modifier: Modifier = Modifier, cityName: String? = null, weather: WeatherInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.large,

            ) {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (!cityName.isNullOrEmpty()) {
                    Text(
                        text = cityName,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = modifier.height(5.dp))
                }
                Text(
                    text = weather.time.formatDate(),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary

                )
                Spacer(modifier = modifier.height(20.dp))
                if (!weather.iconUrl.isNullOrEmpty())
                    AsyncImage(
                        model = weather.iconUrl,
                        contentDescription = "",
                        modifier = modifier.size(100.dp)
                    )
                else
                    Image(painter = painterResource(id = R.drawable.placeholder), contentDescription = "")
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = "${weather.temp.roundToInt()} ${ConditionUnit.TemperatureUnit.name}",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = weather.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = modifier.height(20.dp))
                ConditionsRow(modifier, weather = weather)
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherInfoItem() {
    WeatherInfoItem(
        modifier = Modifier,
        cityName = "Cairo",
        weather = WeatherInfo(
            "2024-04-06",
            temp = 12f,
            windSpeed = 1f,
            humidity = 10f,
            cityName = "Cairo",
            iconUrl = "c01d".generateUrlFromIconCode(),
            pressure = 22f,
            description = ""
        )
    )
}