package com.example.hearthstonelist.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstonelist.MobileNavigationDirections
import com.example.hearthstonelist.databinding.FragmentBaseBinding
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.ui.adapter.CardsAdapter
import com.example.hearthstonelist.ui.viewmodel.CardListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseCardListFragment() : Fragment() {

    // ViewModel & Binding
    val viewModel: CardListViewModel by viewModel()
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    // Adapter
    private val adapter: CardsAdapter by inject()

    // Transition
    private var transition = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {

        // Binding
        _binding = FragmentBaseBinding.inflate(inflater, container, false)

        // Recycler & Adapter
        binding.recyclerCards.layoutManager = LinearLayoutManager(context)
        binding.recyclerCards.adapter = adapter

        val listener = object : CardListener {
            override fun onCardClick(card: CardModel) {
                transition = true
                viewModel.navigate(card)
            }
        }

        adapter.attachListener(listener)

        // Observers
        observe()

        return binding.root
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
        viewModel.clickCard.observe(viewLifecycleOwner) {
            if (transition == true) {
                val direction = MobileNavigationDirections.actionGlobalNavCompleteCard(it)
                findNavController().navigate(direction)
                transition = false
            }
        }
    }
}
