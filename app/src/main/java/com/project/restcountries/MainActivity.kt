package com.project.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.restcountries.model.Countries
import com.project.restcountries.services.CountryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.list_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val characterService = CountryService.Factory.create()
        val countries: Call<MutableList<Countries>> = characterService.getServices()
        countries.enqueue(object : Callback<MutableList<Countries> >{
            override fun onFailure(call: Call<MutableList<Countries>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<MutableList<Countries>>,
                response: Response<MutableList<Countries>>
            ) {
                var list = response.body()!!
                recyclerView.adapter = CountryAdapter(list)


            }



        })
    }
}
