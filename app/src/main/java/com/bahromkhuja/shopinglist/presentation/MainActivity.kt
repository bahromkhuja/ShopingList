package com.bahromkhuja.shopinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bahromkhuja.shopinglist.R
import com.bahromkhuja.shopinglist.databinding.ActivityMainBinding
import com.bahromkhuja.shopinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList:LinearLayout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llShopList = binding.llShopList
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            Log.e("TestTag", it.toString())
            showList(it)
        }
        viewModel.changeEnabledState(ShopItem(name="Name 0", count=0, enabled=false, id=0))
//        viewModel.deleteItem(ShopItem(name="Name 1", count=1, enabled=false, id=1))
    }

    private fun showList(list: List<ShopItem>){
        llShopList.removeAllViews()
        for (i in list){
            val layoutId = if(i.enabled){
                R.layout.item_shop_enabled
            }else{
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val name = view.findViewById<TextView>(R.id.tv_name)
            val count = view.findViewById<TextView>(R.id.tv_count)
            name.text = i.name
            count.text = i.count.toString()
            view.setOnLongClickListener {
                viewModel.changeEnabledState(i)
                true
            }
            llShopList.addView(view)
        }
    }
}