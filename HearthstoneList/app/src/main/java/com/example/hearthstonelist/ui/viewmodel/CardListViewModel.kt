package com.example.hearthstonelist.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.repository.CardRepository

class CardListViewModel(private val repository: CardRepository) : ViewModel() {

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
        repository.listAll(listener)
    }

    fun listClass(hsClass: String) {
        repository.listClass(hsClass, listener)

    }
    fun navigate(card: CardModel) {
        _clickCard.value = card
    }
}
