package com.example.databindingwithlivedata

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class MainRepo(context: Context) {

    private val fruitNames = listOf<String>("Apple","Banana","Guava","Papaya","Mango","Strawberry")
    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName : LiveData<String> = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }
}