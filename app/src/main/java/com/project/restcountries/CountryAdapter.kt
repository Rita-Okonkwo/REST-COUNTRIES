package com.project.restcountries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.project.restcountries.model.Countries
import com.project.restcountries.model.Country2
import java.net.URL
import kotlin.coroutines.coroutineContext

class CountryAdapter(var countryList: List<Country2>, var activity: MainActivity): RecyclerView.Adapter<CountryAdapter.ViewHolder>(){
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        context = parent.context!!
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.name.text = countryList[position].name
        holder.capital.text = countryList[position].capital

        SvgLoader.pluck()
            .with(activity)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(countryList[position].flag, holder.flag)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.country_name)
        val capital: TextView = itemView.findViewById(R.id.country_capital)
        val flag: ImageView = itemView.findViewById(R.id.country_flag)

    }

}