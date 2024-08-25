package com.droidcourses.composeui.ui.themechanger

enum class AppThemMode {
    Mode_Light,
    Mode_Dark,
    Mode_Auto;

    companion object  {
        fun fromOrdinal(option: Int) = entries[option]
    }
}