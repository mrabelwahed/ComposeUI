package com.droidcourses.composeui.ui.themechanger.settings

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.droidcourses.composeui.ui.themechanger.AppThemMode
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface UserSettings {
    val themeStream: StateFlow<AppThemMode>
    var theme: AppThemMode
}

class UserSettingsImpl @Inject constructor(@ApplicationContext context: Context): UserSettings {
    override val themeStream: MutableStateFlow<AppThemMode>
    override var theme: AppThemMode by AppThemePreferenceDelegate("app_theme", AppThemMode.Mode_Auto)
    private val preferences : SharedPreferences = context.getSharedPreferences("app_theme",Context.MODE_PRIVATE)

    init {
        themeStream = MutableStateFlow(theme)
    }

    inner class AppThemePreferenceDelegate(private val name: String, private val default: AppThemMode): ReadWriteProperty<Any?, AppThemMode> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): AppThemMode {
            return  AppThemMode.fromOrdinal(preferences.getInt(name, default.ordinal))
        }

        @SuppressLint("SuspiciousIndentation")
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: AppThemMode) {
          themeStream.value = value
            preferences.edit {
             putInt(name, value.ordinal)
            }
        }

    }
}