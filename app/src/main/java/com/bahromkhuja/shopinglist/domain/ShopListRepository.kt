package com.bahromkhuja.shopinglist.domain

interface ShopListRepository {

    fun getShopList(): List<ShopItem>

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId:Int): ShopItem

    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)
}