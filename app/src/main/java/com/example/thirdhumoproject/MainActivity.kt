package com.example.thirdhumoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.APP_ACTIVITY
import com.example.replaceFragment
import com.example.thirdhumoproject.ui.MainFragment
import com.example.thirdhumoproject.ui.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY=this
    }


    override fun onResume() {
        super.onResume()
        replaceFragment(MainFragment(),false)
    }
}