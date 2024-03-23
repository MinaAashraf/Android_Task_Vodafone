package com.android_task_vodafone.core.utils.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android_task_vodafone.core.utils.ConditionType
import com.android_task_vodafone.core.utils.ConditionUnit

@Composable
fun ConditionItem(modifier: Modifier = Modifier, conditionValue: String, conditionLabel: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = conditionValue,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = conditionLabel,
            style = MaterialTheme.typography.labelSmall,
            color = Color.DarkGray
        )
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewConditionItem() {
    ConditionItem(conditionValue = "50 ${ConditionUnit.WindSpeedUnit.name}", conditionLabel = ConditionType.WindSpeed.name)
}