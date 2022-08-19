package com.example.hearthstonelist.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstonelist.databinding.RowCardListBinding
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel

class CardsViewHolder(private val itemBinding: RowCardListBinding, val listener: CardListener) :
    RecyclerView.ViewHolder(itemBinding.root) {


    fun bindData(card: CardModel?) {

        // Bind Data
        itemBinding.textCardName.text = card?.cardName
        itemBinding.textCardRarity.text = "Rarity:" +card?.rarity
        itemBinding.textCardCost.text = "Cost:" +card?.cost.toString()

        // Events
        itemBinding.textCardName.setOnClickListener { listener.onCardClick(card!!) }
        itemBinding.textCardRarity.setOnClickListener { listener.onCardClick(card!!) }
        itemBinding.textCardCost.setOnClickListener { listener.onCardClick(card!!) }
    }
}
