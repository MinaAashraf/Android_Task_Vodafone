package com.android_task_vodafone.di

import com.android_task_vodafone.core.utils.IoDispatcher
import com.android_task_vodafone.core.utils.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @MainDispatcher
    @Provides
    fun provideMainDispatcher() : CoroutineDispatcher = Dispatchers.Main

    @IoDispatcher
    @Provides
    fun provideIoDispatcher () : CoroutineDispatcher = Dispatchers.IO

}