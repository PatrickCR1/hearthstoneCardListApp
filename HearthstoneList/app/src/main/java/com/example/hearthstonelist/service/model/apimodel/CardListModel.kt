package com.example.hearthstonelist.service.model.apimodel

import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.google.gson.annotations.SerializedName

data class CardListModel(

    @SerializedName("Basic")
    var listBasic: List<CardModelApi> = emptyList(),

    @SerializedName("Classic")
    var listClassic: List<CardModelApi> = emptyList(),

    @SerializedName("Hall of Fame")
    var listHallOfFame: List<CardModelApi> = emptyList(),

    @SerializedName("Naxxramas")
    var listNaxxramas: List<CardModelApi> = emptyList(),

    @SerializedName("Goblins vs Gnomes")
    var listGoblinGnomes: List<CardModelApi> = emptyList(),

    @SerializedName("Blackrock Mountain")
    var listBlackrockMountain: List<CardModelApi> = emptyList(),

    @SerializedName("The Grand Tournament")
    var listTheGrandTournament: List<CardModelApi> = emptyList(),

    @SerializedName("Hero Skins")
    var listHeroSkins: List<CardModelApi> = emptyList(),

    @SerializedName("The League Of Explorers")
    var listLeagueOfExplorers: List<CardModelApi> = emptyList(),

    @SerializedName("Whispers of the Old Gods")
    var listWhispersOfTheOldGods: List<CardModelApi> = emptyList(),

    @SerializedName("One Night in Karazhan")
    var listOneNightInKarazhan: List<CardModelApi> = emptyList(),

    @SerializedName("Mean Streets of Gadgetzan")
    var listMeanStreetsofGadgetzan: List<CardModelApi> = emptyList(),

    @SerializedName("Journey to Un'Goro")
    var listJourneytoUnGoro: List<CardModelApi> = emptyList(),

    @SerializedName("Knights of the Frozen Throne")
    var listKnightsOfTheFrozenThrone: List<CardModelApi> = emptyList(),

    @SerializedName("Kobolds & Catacombs")
    var listKoboldsCatacombs: List<CardModelApi> = emptyList(),

    @SerializedName("The Witchwood")
    var listTheWitchwood: List<CardModelApi> = emptyList(),

    @SerializedName("The Boomsday Project")
    var listTheBoomsdayProject: List<CardModelApi> = emptyList(),

    @SerializedName("Rastakhan's Rumble")
    var listRastakhansRumble: List<CardModelApi> = emptyList(),

    @SerializedName("Rise of Shadows")
    var listRiseOfShadows: List<CardModelApi> = emptyList(),

    @SerializedName("Saviors of Uldum")
    var listSaviorsOfUldum: List<CardModelApi> = emptyList(),

    @SerializedName("Descent of Dragons")
    var listDescentOfDragons: List<CardModelApi> = emptyList(),

    @SerializedName("Galakrond's Awakening")
    var listGalakrondsAwakening: List<CardModelApi> = emptyList(),

    @SerializedName("Ashes of Outland")
    var listAshesOfOutland: List<CardModelApi> = emptyList(),

    @SerializedName("Scholomance Academy")
    var listScholomanceAcademy: List<CardModelApi> = emptyList(),

    @SerializedName("Demon Hunter Initiate")
    var listDemonHunterInitiate: List<CardModelApi> = emptyList(),

    @SerializedName("Madness At The Darkmoon Faire")
    var listMadnessAtTheDarkmoonFaire: List<CardModelApi> = emptyList(),

    @SerializedName("Forged in the Barrens")
    var listForgedInTheBarrens: List<CardModelApi> = emptyList(),

    @SerializedName("Legacy")
    var listLegacy: List<CardModelApi> = emptyList(),

    @SerializedName("Core")
    var listCore: List<CardModelApi> = emptyList(),

    @SerializedName("Vanilla")
    var listVanilla: List<CardModelApi> = emptyList(),

    @SerializedName("United in Stormwind")
    var listUnitedInStormwind: List<CardModelApi> = emptyList(),

    @SerializedName("Fractured in Alterac Valley")
    var listFracturedInAlteracValley: List<CardModelApi> = emptyList(),

    @SerializedName("Voyage to the Sunken City")
    var listVoyageToTheSunkenCity: List<CardModelApi> = emptyList(),

    @SerializedName("Unknown")
    var listUnknown: List<CardModelApi> = emptyList(),

    @SerializedName("Murder at Castle Nathria")
    var listMurderAtCastleNathria: List<CardModelApi> = emptyList(),

    )
