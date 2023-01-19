package com.example.hearthstonelist.service.repository

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.apimodel.CardListModel
import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.toCardModel
import retrofit2.Response

class CardRepository(private val webService: CardService) {

    // Get Lists
    suspend fun listAll(listener: APIListener<List<CardModel?>>) {
        val response = webService.listAll()
        if (response.isSuccessful) {
            responseSuccessfulListAll(response, listener)
        } else {
            listener.onFailure(null)
        }
    }

    private fun responseSuccessfulListAll(
        response: Response<CardListModel>,
        listener: APIListener<List<CardModel?>>
    ) {
        if (response.code() == HSConstants.HTTP.SUCCESS) {
            var apiList = arrayListOf<CardModelApi?>()

            apiList.addAll(response.body()?.listBasic!!)
            apiList.addAll(response.body()?.listClassic!!)
            apiList.addAll(response.body()?.listHallOfFame!!)
            apiList.addAll(response.body()?.listNaxxramas!!)
            apiList.addAll(response.body()?.listGoblinGnomes!!)
            apiList.addAll(response.body()?.listBlackrockMountain!!)
            apiList.addAll(response.body()?.listTheGrandTournament!!)
            apiList.addAll(response.body()?.listHeroSkins!!)
            apiList.addAll(response.body()?.listLeagueOfExplorers!!)
            apiList.addAll(response.body()?.listWhispersOfTheOldGods!!)
            apiList.addAll(response.body()?.listOneNightInKarazhan!!)
            apiList.addAll(response.body()?.listMeanStreetsofGadgetzan!!)
            apiList.addAll(response.body()?.listJourneytoUnGoro!!)
            apiList.addAll(response.body()?.listKnightsOfTheFrozenThrone!!)
            apiList.addAll(response.body()?.listKoboldsCatacombs!!)
            apiList.addAll(response.body()?.listTheWitchwood!!)
            apiList.addAll(response.body()?.listTheBoomsdayProject!!)
            apiList.addAll(response.body()?.listRastakhansRumble!!)
            apiList.addAll(response.body()?.listRiseOfShadows!!)
            apiList.addAll(response.body()?.listSaviorsOfUldum!!)
            apiList.addAll(response.body()?.listDescentOfDragons!!)
            apiList.addAll(response.body()?.listGalakrondsAwakening!!)
            apiList.addAll(response.body()?.listAshesOfOutland!!)
            apiList.addAll(response.body()?.listScholomanceAcademy!!)
            apiList.addAll(response.body()?.listDemonHunterInitiate!!)
            apiList.addAll(response.body()?.listMadnessAtTheDarkmoonFaire!!)
            apiList.addAll(response.body()?.listForgedInTheBarrens!!)
            apiList.addAll(response.body()?.listLegacy!!)
            apiList.addAll(response.body()?.listCore!!)
            apiList.addAll(response.body()?.listVanilla!!)
            apiList.addAll(response.body()?.listUnitedInStormwind!!)
            apiList.addAll(response.body()?.listFracturedInAlteracValley!!)
            apiList.addAll(response.body()?.listVoyageToTheSunkenCity!!)
            apiList.addAll(response.body()?.listUnknown!!)
            apiList.addAll(response.body()?.listMurderAtCastleNathria!!)

            val allCardList: List<CardModel?> = apiList.map { it?.toCardModel() }

            listener.onSuccess(allCardList)

        } else {
            listener.onFailure(null)
        }
    }

    suspend fun listClass(hsClass: String, listener: APIListener<List<CardModel?>>) {
        val response = webService.listClass(hsClass)
        if (response.isSuccessful) {
            responseSuccessfulListClass(response, listener)
        } else {
            listener.onFailure(null)
        }
    }

    private fun responseSuccessfulListClass(
        response: Response<List<CardModelApi>>,
        listener: APIListener<List<CardModel?>>
    ) {
        if (response.code() == HSConstants.HTTP.SUCCESS) {
            var apiList = response.body()
            val classList: List<CardModel?> = apiList!!.map { it.toCardModel() }
            response.body()?.let { listener.onSuccess(classList) }
        } else {
            listener.onFailure(null)
        }
    }
}
