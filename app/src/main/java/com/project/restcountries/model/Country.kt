package com.project.restcountries.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryProperty(
    val name: String,
    val capital: String,
    val photo: String
)
data class Countries(
    val countries: MutableList<CountryProperty>
)