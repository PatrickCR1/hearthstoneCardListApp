package com.example.hearthstonelist.service.model.apimodel

import com.google.gson.annotations.SerializedName

data class CardModelApi(

    @SerializedName("cardId")
    var cardId: String = "",

    @SerializedName("name")
    var cardName: String = "",

    @SerializedName("cardSet")
    var cardSet: String = "",

    @SerializedName("type")
    var type: String = "",

    @SerializedName("faction")
    var faction: String = "",

    @SerializedName("rarity")
    var rarity: String = "",

    @SerializedName("cost")
    var cost: Int = 0,

    @SerializedName("attack")
    var attack: Int = 0,

    @SerializedName("health")
    var health: Int = 0,

    @SerializedName("flavor")
    var flavor: String = "",

    @SerializedName("text")
    var description: String = "",

    @SerializedName("artist")
    var artist: String = "",

    @SerializedName("collectible")
    var collectible: Boolean = false,

    @SerializedName("elite")
    var elite: Boolean = false,

    @SerializedName("img")
    var image: String = "",

    @SerializedName("imgGold")
    var imageGold: String = "",

    @SerializedName("locale")
    var locale: String = "",

    @SerializedName("playerClass")
    var playerClass: String = ""
)
