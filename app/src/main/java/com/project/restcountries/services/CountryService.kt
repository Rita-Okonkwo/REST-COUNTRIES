package com.project.restcountries.services

import com.project.restcountries.model.Country2
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface CountryService {
    @GET("all")

    fun getServices() : Call<List<Country2>>


    companion object Factory {
        fun create(): CountryService {
          /*  val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()*/
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://restcountries.eu/rest/v2/")
                .build()

            return retrofit.create(CountryService::class.java)
        }
    }
}