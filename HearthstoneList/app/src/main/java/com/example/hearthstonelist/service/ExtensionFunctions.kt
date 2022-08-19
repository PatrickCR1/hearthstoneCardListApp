package com.example.hearthstonelist.service

import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel

fun CardModelApi.toCardModel() = CardModel(
    cardId = cardId,
    cardName = cardName,
    cardSet = cardSet,
    type = type,
    faction = faction,
    rarity = rarity,
    cost = cost,
    attack = attack,
    health = health,
    flavor = flavor,
    description = description,
    artist = artist,
    collectible = collectible,
    elite = elite,
    image = image,
    imageGold = imageGold,
    locale = locale,
    playerClass = playerClass
)