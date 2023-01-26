package com.bahromkhuja.shopinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bahromkhuja.shopinglist.R
import com.bahromkhuja.shopinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            Log.e("TestTag", it.toString())
        }
        viewModel.changeEnabledState(ShopItem(name="Name 0", count=0, enabled=false, id=0))
        viewModel.deleteItem(ShopItem(name="Name 1", count=1, enabled=false, id=1))
    }
}