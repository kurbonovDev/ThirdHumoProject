package com.example.thirdhumoproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.APP_ACTIVITY
import com.example.thirdhumoproject.R
import com.example.thirdhumoproject.data.country_item

class country_adapter(
    private var list_country: List<country_item>,
    private val isPopularXml: Boolean = false
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class PopularCountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.popular_country_image)
        val tvText: TextView = view.findViewById(R.id.country_txt)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.country_image)
        val tvText: TextView = view.findViewById(R.id.country_txt_2)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_country_item, parent, false)

        val itemView2 = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)


        return when (isPopularXml) {
            true -> {
                PopularCountryViewHolder(itemView)
            }

            false -> {
                MyViewHolder(itemView2)
            }
        }
    }

    override fun getItemCount(): Int = list_country.size


    fun setFilterList(list: List<country_item>) {
        this.list_country = list
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PopularCountryViewHolder -> {
                holder.imageView.setImageResource(list_country[position].image)
                holder.tvText.text = list_country[position].name_country
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        APP_ACTIVITY,
                        list_country[position].name_country,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            is MyViewHolder -> {
                holder.imageView.setImageResource(list_country[position].image)
                holder.tvText.text = list_country[position].name_country
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        APP_ACTIVITY,
                        list_country[position].name_country,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}