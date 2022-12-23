package com.example.udacityshoestore.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udacityshoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList : LiveData<ArrayList<Shoe>>
        get() = _shoeList
    var shoe = Shoe()
    init {
        _shoeList.value = ArrayList()
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        Log.i("ShoeListViewModel", "Shoe added to list and shoeList is now ${_shoeList.value}")
    }
}