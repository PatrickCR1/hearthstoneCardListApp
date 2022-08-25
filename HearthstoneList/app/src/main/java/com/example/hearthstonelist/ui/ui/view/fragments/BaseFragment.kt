package com.example.hearthstonelist.ui.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstonelist.MobileNavigationDirections
import com.example.hearthstonelist.databinding.FragmentBaseBinding
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.ui.ui.adapter.CardsAdapter
import com.example.hearthstonelist.ui.ui.viewmodel.CardListViewModel

abstract class BaseFragment : Fragment() {

    // ViewModel & Binding
    private lateinit var viewModel: CardListViewModel
    private var _binding: FragmentBaseBinding? = null
    private val binding get() = _binding!!

    // Adapter
    private val adapter = CardsAdapter()

    // Transition
    private var transition = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {

        // Binding && ViewModel
        viewModel = ViewModelProvider(this).get(CardListViewModel::class.java)
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
        adapter.getContext(requireContext())

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