package com.example.hearthstonelist

import com.example.hearthstonelist.service.model.apimodel.CardListModel
import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel

val emptyCardModelSample = CardModel()

val cardModelSample = CardModel(
    cardName = "Circle of Healing",
    description = "Heal",
    flavor = "Circle",
    rarity = "Rare",
    type = "Normal",
    faction = "Hero",
    cardSet = "Basic",
    cost = 0,
    attack = 1,
    health = 2,
)

val cardListSample = mutableListOf<CardModel?>().apply { this.add(emptyCardModelSample) }

val cardListApiSample = mutableListOf<CardModelApi>().apply { this.add(cardModelApi) }

val cardListModelSample = CardListModel(
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample,
    cardListApiSample
)


val cardModelApi = CardModelApi(
    cardName = "Circle of Healing",
    description = "Heal",
    flavor = "Circle",
    rarity = "Rare",
    type = "Normal",
    faction = "Hero",
    cardSet = "Basic",
    cost = 0,
    attack = 1,
    health = 2,
)


val stringSample = ""