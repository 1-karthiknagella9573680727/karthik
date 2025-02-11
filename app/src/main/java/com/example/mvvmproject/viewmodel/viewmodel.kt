package com.example.mvvmproject.viewmodel

import androidx.compose.runtime.mutableStateListOf



import androidx.lifecycle.ViewModel

import com.example.mvvmproject.model.Item

class ItemViewModel : ViewModel() {
    // This is a list of items, initialize it as an empty list
    var items = mutableStateListOf<Item>()
        private set

    // Function to add an item
    fun addItem(item: Item) {
        items.add(item)
    }
}
