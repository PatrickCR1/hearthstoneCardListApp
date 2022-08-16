package com.example.hearthstonelist.service.repository

import com.example.hearthstonelist.service.model.CardListModel
import com.example.hearthstonelist.service.model.CardModel
import retrofit2.Call
import retrofit2.http.*

interface CardService {

    @GET("cards?collectible=1")
    fun listAll(): Call<CardListModel>

    @GET("cards/classes/{class}?collectible=1")
    fun listClass(@Path ("class") hsClass: String): Call<List<CardModel>>


}