package com.example.hearthstonelist.service.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.hearthstonelist.R
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.apimodel.CardListModel
import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.toCardModel
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
                    var apiList = arrayListOf<CardModelApi?>()

                    for (card in (response.body())?.listBasic!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listClassic!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listHallOfFame!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listNaxxramas!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listGoblinGnomes!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listBlackrockMountain!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listTheGrandTournament!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listHeroSkins!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listLeagueOfExplorers!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listWhispersOfTheOldGods!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listOneNightInKarazhan!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listMeanStreetsofGadgetzan!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listJourneytoUnGoro!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listKnightsOfTheFrozenThrone!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listKoboldsCatacombs!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listTheWitchwood!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listTheBoomsdayProject!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listRastakhansRumble!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listRiseOfShadows!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listSaviorsOfUldum!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listDescentOfDragons!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listGalakrondsAwakening!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listAshesOfOutland!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listScholomanceAcademy!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listDemonHunterInitiate!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listMadnessAtTheDarkmoonFaire!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listForgedInTheBarrens!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listLegacy!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listCore!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listVanilla!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listUnitedInStormwind!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listFracturedInAlteracValley!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listVoyageToTheSunkenCity!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listUnknown!!) {
                        apiList.add(card)
                    }
                    for (card in (response.body())?.listMurderAtCastleNathria!!) {
                        apiList.add(card)
                    }

                    val allCardList: List<CardModel?> = apiList.map { it?.toCardModel() }

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

    fun executeCallClass(call: Call<List<CardModelApi>>, listener: APIListener<List<CardModel?>>) {
        call.enqueue(object : Callback<List<CardModelApi>> {

            override fun onResponse(call: Call<List<CardModelApi>>,response: Response<List<CardModelApi>>) {
                if (response.code() == HSConstants.HTTP.SUCCESS) {
                    var apiList = response.body()
                    val classList: List<CardModel?> = apiList!!.map { it.toCardModel() }
                    response.body()?.let { listener.onSuccess(classList) }
                } else {
                    listener.onFailure(failResponse(response.errorBody()!!.string()))
                }
            }

            override fun onFailure(call: Call<List<CardModelApi>>, t: Throwable) {
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
