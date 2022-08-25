package com.example.hearthstonelist.ui.ui.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.repository.CardRepository

class CardListViewModel(application: Application) : AndroidViewModel(application) {

    private val cardRepository = CardRepository(application.applicationContext)

    // Live Data
    private val _cards = MutableLiveData<List<CardModel?>>()
    val cards: LiveData<List<CardModel?>> = _cards

    private val _clickCard = MutableLiveData<CardModel>()
    val clickCard: LiveData<CardModel> = _clickCard

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
    fun navigate(card: CardModel) {
        _clickCard.value = card
    }
}
