package com.bahromkhuja.shopinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bahromkhuja.shopinglist.data.ShopListRepositoryImpl
import com.bahromkhuja.shopinglist.domain.DeleteShopItemUseCase
import com.bahromkhuja.shopinglist.domain.EditShopItemUseCase
import com.bahromkhuja.shopinglist.domain.GetShopListUseCase
import com.bahromkhuja.shopinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val item = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(item)
    }

}