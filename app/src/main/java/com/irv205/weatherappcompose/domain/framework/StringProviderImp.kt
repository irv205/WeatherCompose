package com.irv205.weatherappcompose.domain.framework

import android.content.Context
import com.irv205.weatherappcompose.domain.StringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringProviderImp @Inject constructor(
    @ApplicationContext private val context: Context
): StringProvider {
    override fun getString(idString: Int, vararg parameters: Any): String {
        return context.getString(idString, *parameters)
    }
}