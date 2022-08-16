package com.example.hearthstonelist.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstonelist.databinding.RowCardListBinding
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.CardModel
import com.example.hearthstonelist.view.viewholder.CardsViewHolder


class CardsAdapter : RecyclerView.Adapter<CardsViewHolder>() {

    private var listCards: List<CardModel?> = arrayListOf()
    private lateinit var listener: CardListener
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowCardListBinding.inflate(inflater, parent, false)
        return CardsViewHolder(itemBinding, listener)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bindData(listCards[position])
    }

    override fun getItemCount(): Int {
        return listCards.count()

    }

    // Card List
    fun updateList(list: List<CardModel?>) {
        listCards = list
        notifyDataSetChanged()
    }

    // Listener
    fun attachListener(cardListener: CardListener) {
        listener = cardListener
    }

    // Context
    fun getContext(getContext: Context) {
        context = getContext
    }

}