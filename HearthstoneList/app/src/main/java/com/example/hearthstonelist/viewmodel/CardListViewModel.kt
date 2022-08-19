package com.example.hearthstonelist.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.repository.CardRepository
import com.example.hearthstonelist.view.CompleteCardActivity

class CardListViewModel(application: Application) : AndroidViewModel(application) {

    private val cardRepository = CardRepository(application.applicationContext)

    // Live Data
    private val _cards = MutableLiveData<List<CardModel?>>()
    val cards: LiveData<List<CardModel?>> = _cards

    private val _clickCard = MutableLiveData<Intent>()
    val clickCard: LiveData<Intent> = _clickCard

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
    fun onClick(context: Context, card: CardModel) {
        val intent = Intent(context, CompleteCardActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(HSConstants.BUNDLE.CARD, card)
        intent.putExtras(bundle)
        _clickCard.value = intent
    }
}
