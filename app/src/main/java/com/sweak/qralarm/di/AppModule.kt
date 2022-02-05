package com.sweak.qralarm.di

import android.app.AlarmManager
import android.app.Application
import android.app.Service
import com.sweak.qralarm.alarm.QRAlarmManager
import com.sweak.qralarm.data.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataStoreManager(app: Application): DataStoreManager =
        DataStoreManager(app)

    @Provides
    @Singleton
    fun provideQrAlarmManager(alarmManager: AlarmManager, app: Application): QRAlarmManager =
        QRAlarmManager(alarmManager, app)

    @Provides
    @Singleton
    fun provideAlarmManager(app: Application): AlarmManager =
        app.getSystemService(Service.ALARM_SERVICE) as AlarmManager
}