package com.example.hearthstonelist.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.hearthstonelist.R
import com.example.hearthstonelist.databinding.FragmentCompleteCardBinding
import com.example.hearthstonelist.service.image.ImageService
import com.example.hearthstonelist.service.model.domainmodel.CardModel

class CompleteCardFragment : Fragment() {

    private var _binding: FragmentCompleteCardBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<CompleteCardFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompleteCardBinding.inflate(layoutInflater)


        // Load Args
        val card = args.cardModel
        loadDataFromMain(requireContext(), card)

        return binding.root
    }

    private fun loadDataFromMain(context: Context, card: CardModel) {
        binding.textCardName.text = card.cardName
        binding.textCardFlavor.text = card.flavor
        binding.textCardText.text = card.description
        binding.textCardRarity.text = getString(R.string.card_rarity, card.rarity)
        binding.textCardSet.text = getString(R.string.card_set, card.cardSet)
        binding.textCardType.text = getString(R.string.card_type, card.type)
        binding.textCardFaction.text = getString(R.string.card_faction, card.faction)
        binding.textCardCost.text = getString(R.string.card_cost, card.cost)
        binding.textCardAttack.text = getString(R.string.card_attack, card.attack)
        binding.textCardHealth.text = getString(R.string.card_health, card.health)
        val image = card.image

        ImageService.loadImage(context, image, binding.imageCard)
    }
}
