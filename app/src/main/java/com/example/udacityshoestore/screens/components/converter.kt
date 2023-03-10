package com.example.udacityshoestore.screens.components

import androidx.databinding.InverseMethod

object IntConverter {

    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(value: Int?): String {
        return value?.toString() ?: ""
    }

    @JvmStatic
    fun stringToInt(value: String): Int? {
        return if (value.isNotEmpty()) {
            value.toInt()
        } else {
            null
        }
    }
}