package com.example.hearthstonelist

import com.example.hearthstonelist.service.model.apimodel.CardListModel
import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel

val cardModelApiSample = CardModelApi()

val cardListApiSample = mutableListOf<CardModelApi?>().apply { this.add(cardModelApiSample) }

val cardListModelSample = CardListModel()

val emptyCardListSample = mutableListOf<CardModel?>()

val emptyCardListApiSample = mutableListOf<CardModelApi>()

val stringSample = ""
