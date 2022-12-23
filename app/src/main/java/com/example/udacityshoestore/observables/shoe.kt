package com.example.udacityshoestore.observables

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt


class User {
    val name = ObservableField<String>()
    val size = ObservableInt()
    val company = ObservableField<String>()
    val description = ObservableField<String>()
}