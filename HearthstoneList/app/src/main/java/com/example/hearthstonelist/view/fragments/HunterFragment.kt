package com.example.hearthstonelist.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstonelist.R
import com.example.hearthstonelist.databinding.FragmentAllCardsBinding
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.CardModel
import com.example.hearthstonelist.view.CompleteCardActivity
import com.example.hearthstonelist.view.adapter.CardsAdapter
import com.example.hearthstonelist.viewmodel.CardListViewModel

class HunterFragment : Fragment() {
    private lateinit var viewModel: CardListViewModel
    private var _binding: FragmentAllCardsBinding? = null
    private val binding get() = _binding!!

    private val adapter = CardsAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {

        // Binding && ViewModel
        viewModel = ViewModelProvider(this).get(CardListViewModel::class.java)
        _binding = FragmentAllCardsBinding.inflate(inflater, container, false)

        // Recycler & Adapter
        binding.recyclerAllCards.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllCards.adapter = adapter

        val listener = object : CardListener {
            override fun onCardClick(card: CardModel) {
                val intent = Intent(context, CompleteCardActivity::class.java)
                val bundle = Bundle()
                bundle.putString(HSConstants.BUNDLE.IMAGE, card.image)
                bundle.putString(HSConstants.BUNDLE.NAME, card.cardName)
                bundle.putString(HSConstants.BUNDLE.FLAVOR, card.flavor)
                bundle.putString(HSConstants.BUNDLE.DESCRIPTION, card.description)
                bundle.putString(HSConstants.BUNDLE.CARD_SET, card.cardSet)
                bundle.putString(HSConstants.BUNDLE.TYPE, card.type)
                bundle.putString(HSConstants.BUNDLE.FACTION, card.faction)
                bundle.putString(HSConstants.BUNDLE.RARITY, card.rarity)
                bundle.putInt(HSConstants.BUNDLE.ATTACK, card.attack)
                bundle.putInt(HSConstants.BUNDLE.HEALTH, card.health)
                bundle.putInt(HSConstants.BUNDLE.COST, card.cost)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

        adapter.attachListener(listener)
        adapter.getContext(requireContext())

        // Observers
        observe()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.HUNTER)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.cards.observe(viewLifecycleOwner) {
            adapter.updateList(it)
            binding.progressCircular.isGone = true
        }
    }

}
