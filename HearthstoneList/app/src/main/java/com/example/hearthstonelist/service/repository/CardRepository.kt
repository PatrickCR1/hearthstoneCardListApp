package com.example.hearthstonelist.service.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.hearthstonelist.R
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.CardListModel
import com.example.hearthstonelist.service.model.CardModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardRepository(val context: Context) {

    private val remote = RetrofitClient.getService(CardService::class.java)

    // Get Lists
    fun listAll(listener: APIListener<List<CardModel?>>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCallAll(remote.listAll(), listener)

    }

    fun listClass(hsClass: String, listener: APIListener<List<CardModel?>>) {
        if (!isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        executeCallClass(remote.listClass(hsClass), listener)
    }

    // Calls
    fun executeCallAll(call: Call<CardListModel>, listener: APIListener<List<CardModel?>>) {
        call.enqueue(object : Callback<CardListModel> {

            override fun onResponse(call: Call<CardListModel>, response: Response<CardListModel>) {
                if (response.code() == HSConstants.HTTP.SUCCESS) {
                    var allCardList = arrayListOf<CardModel?>()

                    for (card in (response.body())?.listBasic!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listClassic!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listHallOfFame!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listNaxxramas!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listGoblinGnomes!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listBlackrockMountain!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listTheGrandTournament!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listHeroSkins!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listLeagueOfExplorers!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listWhispersOfTheOldGods!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listOneNightInKarazhan!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listMeanStreetsofGadgetzan!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listJourneytoUnGoro!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listKnightsOfTheFrozenThrone!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listKoboldsCatacombs!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listTheWitchwood!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listTheBoomsdayProject!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listRastakhansRumble!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listRiseOfShadows!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listSaviorsOfUldum!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listDescentOfDragons!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listGalakrondsAwakening!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listAshesOfOutland!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listScholomanceAcademy!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listDemonHunterInitiate!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listMadnessAtTheDarkmoonFaire!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listForgedInTheBarrens!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listLegacy!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listCore!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listVanilla!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listUnitedInStormwind!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listFracturedInAlteracValley!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listVoyageToTheSunkenCity!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listUnknown!!) {
                        allCardList.add(card)
                    }
                    for (card in (response.body())?.listMurderAtCastleNathria!!) {
                        allCardList.add(card)
                    }

                    listener.onSuccess(allCardList)
                } else {
                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }
            }
            override fun onFailure(call: Call<CardListModel?>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })

    }

    fun executeCallClass(call: Call<List<CardModel>>, listener: APIListener<List<CardModel?>>) {
        call.enqueue(object : Callback<List<CardModel>> {

            override fun onResponse(call: Call<List<CardModel>>, response: Response<List<CardModel>>) {
                if (response.code() == HSConstants.HTTP.SUCCESS) {

                    response.body()?.let { listener.onSuccess(it) }
                } else {
                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }
            }
            override fun onFailure(call: Call<List<CardModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })

    }

    private fun failResponse(str: String): String {
        return Gson().fromJson(str, String::class.java)
    }

    // Check Internet
    fun isConnectionAvailable(): Boolean {
        var result = false

        // Gerenciador de conexão
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Verifica versão do sistema rodando a aplicação
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNet = cm.activeNetwork ?: return false
            val netWorkCapabilities = cm.getNetworkCapabilities(activeNet) ?: return false
            result = when {
                netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                netWorkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            if (cm.activeNetworkInfo != null) {
                result = when (cm.activeNetworkInfo!!.type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }

        return result
    }

}