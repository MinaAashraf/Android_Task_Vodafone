package com.android_task_vodafone.core.utils.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android_task_vodafone.core.utils.ConditionType
import com.android_task_vodafone.core.utils.ConditionUnit
import com.android_task_vodafone.core.utils.WeatherInfo
import kotlin.math.roundToInt

@Composable
fun ConditionsRow(modifier: Modifier = Modifier, weather : WeatherInfo) {
    Card(
        modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = CircleShape,
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConditionItem(
                conditionValue = "${weather.windSpeed.roundToInt()} ${ConditionUnit.WindSpeedUnit.name}",
                conditionLabel = ConditionType.WindSpeed.name
            )
            ConditionItem(
                conditionValue = "${weather.pressure.roundToInt()} ${ConditionUnit.PressureUnit.name}",
                conditionLabel = ConditionType.Pressure.name
            )
            ConditionItem(
                conditionValue = "${weather.humidity.roundToInt()} ${ConditionUnit.HumidityUnit.name}",
                conditionLabel = ConditionType.Humidity.name
            )
        }

    }

}
