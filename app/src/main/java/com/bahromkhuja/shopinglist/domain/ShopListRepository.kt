package com.bahromkhuja.shopinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopList(): LiveData<List<ShopItem>>

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId:Int): ShopItem

    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)
}