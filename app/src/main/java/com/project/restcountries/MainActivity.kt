package com.project.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.restcountries.model.Country2
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
        val countries: Call<List<Country2>> = characterService.getServices()


        countries.enqueue(object : Callback<List<Country2>> {
            override fun onFailure(call: Call<List<Country2>>, t: Throwable) {
                Log.d("XXXX", t.toString())

                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Country2>>,
                response: Response<List<Country2>>
            ) {

                Log.d("XXXX", response.body().toString())

                var list = response.body()!!
//                recyclerView.adapter = CountryAdapter(list)


            }



        })
    }
}
