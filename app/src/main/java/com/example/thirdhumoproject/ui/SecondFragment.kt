package com.example.thirdhumoproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.APP_ACTIVITY
import com.example.replaceFragment
import com.example.thirdhumoproject.R
import com.example.thirdhumoproject.adapters.country_adapter
import com.example.thirdhumoproject.data.country_item
import com.example.thirdhumoproject.databinding.FragmentSecondBinding
import java.util.Locale


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var rcView:RecyclerView
    private lateinit var adapter: country_adapter
    private lateinit var searchView: SearchView

    private var countries = listOf<country_item>(
        country_item("Россия",R.drawable.ru),
        country_item("Узбекистан",R.drawable.uzb),
        country_item("Таджикистан",R.drawable.tj),
        country_item("Казахстан",R.drawable.kz),
        country_item("ОАЭ",R.drawable.arab),
        country_item("Корея",R.drawable.korea),
        country_item("Украина",R.drawable.ukraine),

    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentSecondBinding.inflate(layoutInflater,container,false)
        return (binding.root)


    }

    override fun onResume() {
        super.onResume()

        initRcView()

        binding.back.setOnClickListener {
            replaceFragment(MainFragment(),false)
        }

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {

        if (query!=null){
            val filtredList =ArrayList<country_item>()
            for (i in countries){
                if (i.name_country.lowercase(Locale.ROOT).contains(query)){
                    filtredList.add(i)
                }
            }

            if (filtredList.isEmpty()){
                Toast.makeText(APP_ACTIVITY,"Не нашлось такой страны !",Toast.LENGTH_SHORT).show()
                adapter.setFilterList(filtredList)
            }else{
                adapter.setFilterList(filtredList)
            }
        }
    }


    private fun initRcView(){

        rcView=binding.rcView
        rcView.layoutManager = LinearLayoutManager(APP_ACTIVITY)
        adapter = country_adapter(countries)
        rcView.adapter=adapter
    }

}