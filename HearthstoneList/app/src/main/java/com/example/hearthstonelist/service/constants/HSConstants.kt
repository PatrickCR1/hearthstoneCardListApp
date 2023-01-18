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

    object IMAGE {
        const val IMAGE_WIDTH = 1600
        const val IMAGE_HEIGHT = 800
        const val LOGO_IMAGE_WIDTH = 800
        const val LOGO_IMAGE_HEIGHT = 600
        const val HEARTHSTONE_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/d/d4/Hearthstone_logo.png/revision/latest/scale-to-width-down/600?cb=20181203195654"
        const val DEMON_HUNTER_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/7/73/RLK_Prologue_Illidan_004hb.png/revision/latest/scale-to-width/360?cb=20221224060635"
        const val DRUID_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/6/63/Malfurion_Stormrage-f.png/revision/latest?cb=20130826143745"
        const val HUNTER_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/8/8b/HERO_05.png/revision/latest/scale-to-width-down/330?cb=20220710063505"
        const val MAGE_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/a/af/HERO_08.png/revision/latest?cb=20220710064122"
        const val PALADIN_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/5/53/Uther_Lightbringer-f.png/revision/latest?cb=20130826144025"
        const val PRIEST_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/b/b2/HERO_09.gif/revision/latest/scale-to-width-down/286?cb=20211205170028"
        const val ROGUE_IMAGE = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM3E8wbf3lt7WhoaFKqciK9Xlgne3danmwgsFYWJ_x338-4FoxWWoi0EZgUJBrY0JL5Cc&usqp=CAU"
        const val SHAMAN_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/5/51/HERO_02.png/revision/latest/scale-to-width-down/330?cb=20220710062824"
        const val WARLOCK_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/8/84/HERO_07.png/revision/latest?cb=20220710063924"
        const val WARRIOR_IMAGE = "https://static.wikia.nocookie.net/hearthstone_gamepedia/images/9/91/Story_03_CorruptGarrosh.png/revision/latest/scale-to-width-down/330?cb=20220710065640"
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
