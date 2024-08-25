package com.droidcourses.composeui.di

import com.droidcourses.composeui.ui.themechanger.settings.UserSettings
import com.droidcourses.composeui.ui.themechanger.settings.UserSettingsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {
    @Binds
    @Singleton
    abstract fun bindUserSettings(
        userSettingsImpl: UserSettingsImpl
    ): UserSettings
}