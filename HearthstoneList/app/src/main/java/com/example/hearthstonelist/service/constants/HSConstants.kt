package com.example.hearthstonelist.service.constants

class HSConstants private constructor() {

    object HEADER {
        const val RAPID_KEY = "X-RapidAPI-Key"
        const val RAPID_HOST = "X-RapidAPI-Host"
        const val KEY = "2c423c0006msh9bdf4a3cdf85538p140b36jsnd5f673ee00a1"
        const val HOST = "omgvamp-hearthstone-v1.p.rapidapi.com"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object BUNDLE {
        const val IMAGE = "image"
        const val NAME = "name"
        const val FLAVOR = "flavor"
        const val DESCRIPTION = "description"
        const val CARD_SET = "cardset"
        const val TYPE = "type"
        const val FACTION = "faction"
        const val RARITY = "rarity"
        const val ATTACK = "attack"
        const val HEALTH = "health"
        const val COST = "cost"
    }

    object CLASS {
        const val DEMON_HUNTER = "demon hunter"
        const val DRUID = "druid"
        const val HUNTER = "hunter"
        const val MAGE = "mage"
        const val PALADIN = "paladin"
        const val PRIEST = "priest"
        const val ROGUE = "rogue"
        const val SHAMAN = "shaman"
        const val WARLOCK = "warlock"
        const val WARRIOR = "warrior"
    }

    object BUILDER {
        const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
    }

}