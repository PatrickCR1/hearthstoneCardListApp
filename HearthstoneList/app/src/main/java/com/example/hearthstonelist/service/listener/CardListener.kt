package com.example.hearthstonelist.service.listener

import com.example.hearthstonelist.service.model.domainmodel.CardModel

interface CardListener {

    fun onCardClick(card: CardModel)

}