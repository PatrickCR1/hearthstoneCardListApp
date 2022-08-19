package com.example.hearthstonelist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hearthstonelist.databinding.FragmentPriestBinding
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.listener.CardListener
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.view.adapter.CardsAdapter
import com.example.hearthstonelist.viewmodel.CardListViewModel

class PriestFragment : Fragment() {

    // ViewModel & Binding
    private lateinit var viewModel: CardListViewModel
    private var _binding: FragmentPriestBinding? = null
    private val binding get() = _binding!!

    // Adapter
    private val adapter = CardsAdapter()

    // Transition
    private var transition = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {

        // Binding && ViewModel
        viewModel = ViewModelProvider(this).get(CardListViewModel::class.java)
        _binding = FragmentPriestBinding.inflate(inflater, container, false)

        // Recycler & Adapter
        binding.recyclerAllCards.layoutManager = LinearLayoutManager(context)
        binding.recyclerAllCards.adapter = adapter

        val listener = object : CardListener {
            override fun onCardClick(card: CardModel) {
                transition = true
                viewModel.onClick(context!!, card)
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
        viewModel.listClass(HSConstants.CLASS.PRIEST)
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
                startActivity(it)
                transition = false
            }
        }
    }
}
