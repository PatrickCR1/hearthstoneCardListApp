package com.example.hearthstonelist.service.model.domainmodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardModel (

    var cardId: String = "",
    var cardName: String = "",
    var cardSet: String = "",
    var type: String = "",
    var faction: String = "",
    var rarity: String = "",
    var cost: Int = 0,
    var attack: Int = 0,
    var health: Int = 0,
    var flavor: String = "",
    var description: String = "",
    var artist: String = "",
    var collectible: Boolean = false,
    var elite: Boolean = false,
    var image: String = "",
    var imageGold: String = "",
    var locale: String = "",
    var playerClass: String = "",

) : Parcelable
