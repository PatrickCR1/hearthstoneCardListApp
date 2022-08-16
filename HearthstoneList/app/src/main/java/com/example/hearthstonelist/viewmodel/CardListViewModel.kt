package com.example.hearthstonelist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.CardModel
import com.example.hearthstonelist.service.repository.CardRepository

class CardListViewModel(application: Application) : AndroidViewModel(application) {

    private val cardRepository = CardRepository(application.applicationContext)

    // Live Data
    private val _cards = MutableLiveData<List<CardModel?>>()
    val cards: LiveData<List<CardModel?>> = _cards

    // Listener
    val listener = object : APIListener<List<CardModel?>> {
        override fun onSuccess(result: List<CardModel?>) {
            _cards.value = result
        }

        override fun onFailure(message: String) {}
    }

    // Get Lists
    fun list() {
        cardRepository.listAll(listener)
    }

    fun listClass(hsClass: String) {
        cardRepository.listClass(hsClass, listener)

    }


}