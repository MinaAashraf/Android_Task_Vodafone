package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.forecast.ForecastDto
import com.android_task_vodafone.features.forecast.domain.model.Forecast

fun ForecastDto.toDomain(): Forecast {
    return Forecast(
        maxTemp = maxTemp,
        minTemp = minTemp,
        iconUrl = weatherIconWithDescription.iconCode.generateUrlFromIconCode(),
        description = weatherIconWithDescription.description
    )
}

fun List<ForecastDto>.toDomainList(): List<Forecast> {
    return map { it.toDomain() }
}