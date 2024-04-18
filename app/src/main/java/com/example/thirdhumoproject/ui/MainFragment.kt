package com.example.thirdhumoproject.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.replaceFragment
import com.example.thirdhumoproject.R
import com.example.thirdhumoproject.adapters.country_adapter
import com.example.thirdhumoproject.data.country_item
import com.example.thirdhumoproject.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var rcView: RecyclerView
    private lateinit var adapter: country_adapter

    private var popularCountryList = listOf<country_item>(
        country_item("Таджикистан", R.drawable.tj),
        country_item("Россия", R.drawable.ru),
        country_item("Узбекстан", R.drawable.uzb)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRcView()

        binding.btnSend.setOnClickListener {
            replaceFragment(SecondFragment())
        }

        binding.cardView2.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=tj.humo.transfer")))
        }
    }


    private fun initRcView() {
        rcView = binding.rcView
        rcView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = country_adapter(popularCountryList,true)
        rcView.adapter = adapter
    }


}