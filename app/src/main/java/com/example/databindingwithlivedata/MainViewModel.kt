package com.example.databindingwithlivedata

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    private lateinit var repo: MainRepo
    lateinit var currentRandomFruitName: LiveData<String>
    private val _displayEditTextContent = MutableLiveData<String>()
    val displayEditTextContent: LiveData<String> = _displayEditTextContent
    val ediTextContent = MutableLiveData<String>()

    fun init(context: Context){
        repo = MainRepo(context)
        currentRandomFruitName = repo.currentRandomFruitName
    }

    fun onChangeRandomFruitClick() = repo.changeCurrentRandomFruitName()

    fun onDisplayEditTextContentValue(){
        _displayEditTextContent.value = ediTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        ediTextContent.value = repo.getRandomFruitName()
    }
}