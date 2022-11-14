package com.irv205.weatherappcompose.domain

import androidx.annotation.StringRes

interface StringProvider {
    fun getString(@StringRes idString: Int, vararg parameters: Any): String
}