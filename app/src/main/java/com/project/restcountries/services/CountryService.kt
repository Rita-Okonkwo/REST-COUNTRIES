package com.project.restcountries.services

import com.project.restcountries.model.Countries
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryService {
    @GET("all")
    fun getServices() : Call<MutableList<Countries>>

    companion object Factory {
        fun create(): CountryService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://restcountries.eu/rest/v2/")
                .build()

            return retrofit.create(CountryService::class.java)
        }
    }
}