package com.example.hearthstonelist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstonelist.R
import com.example.hearthstonelist.databinding.ActivityCompleteCardBinding
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.viewmodel.CompleteCardViewModel

class CompleteCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompleteCardBinding
    private lateinit var viewModel: CompleteCardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel & Binding
        viewModel = ViewModelProvider(this).get(CompleteCardViewModel::class.java)
        binding = ActivityCompleteCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load Bundle
        loadDataFromMain()

    }

    private fun loadDataFromMain() {
        val bundle = intent.extras
        if (bundle != null) {
            val card = bundle.getParcelable<CardModel>(HSConstants.BUNDLE.CARD)
            binding.textCardName.text = card?.cardName
            binding.textCardFlavor.text = card?.flavor
            binding.textCardText.text = card?.description
            binding.textCardRarity.text = getString(R.string.card_rarity) + " " + card?.rarity
            binding.textCardSet.text = getString(R.string.card_set) + " " + card?.cardSet
            binding.textCardType.text = getString(R.string.card_type) + " " + card?.type
            binding.textCardFaction.text = getString(R.string.card_faction) + " " + card?.faction
            binding.textCardCost.text = getString(R.string.card_cost) + " " + card?.cost.toString()
            binding.textCardAttack.text = getString(R.string.card_attack) + " " + card?.attack.toString()
            binding.textCardHealth.text = getString(R.string.card_health) + " " + card?.health.toString()
            val image = card!!.image

            ImageService.loadImage(this, image, binding.imageCard)

        }
    }
}
