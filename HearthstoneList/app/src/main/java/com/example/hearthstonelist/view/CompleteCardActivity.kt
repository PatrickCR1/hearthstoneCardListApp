package com.example.hearthstonelist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstonelist.R
import com.example.hearthstonelist.databinding.ActivityCompleteCardBinding
import com.example.hearthstonelist.databinding.ActivityCompleteCardBinding.inflate
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.viewmodel.CompleteCardViewModel
import com.squareup.picasso.Picasso

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
            binding.textCardName.text = bundle.getString(HSConstants.BUNDLE.NAME)
            binding.textCardFlavor.text = bundle.getString(HSConstants.BUNDLE.FLAVOR)
            binding.textCardText.text = bundle.getString(HSConstants.BUNDLE.DESCRIPTION)
            binding.textCardRarity.text =
                getString(R.string.card_rarity) + " " + bundle.getString(HSConstants.BUNDLE.RARITY)
            binding.textCardSet.text =
                getString(R.string.card_set) + " " + bundle.getString(HSConstants.BUNDLE.CARD_SET)
            binding.textCardType.text =
                getString(R.string.card_type) + " " + bundle.getString(HSConstants.BUNDLE.TYPE)
            binding.textCardFaction.text =
                getString(R.string.card_faction) + " " + bundle.getString(HSConstants.BUNDLE.FACTION)
            binding.textCardCost.text =
                getString(R.string.card_cost) + " " + bundle.getInt(HSConstants.BUNDLE.COST)
                    .toString()
            binding.textCardAttack.text =
                getString(R.string.card_attack) + " " + bundle.getInt(HSConstants.BUNDLE.ATTACK)
                    .toString()
            binding.textCardHealth.text =
                getString(R.string.card_health) + " " + bundle.getInt(HSConstants.BUNDLE.HEALTH)
                    .toString()
            val image = bundle.getString(HSConstants.BUNDLE.IMAGE)

            if (image != "") {
                Picasso.with(this)
                    .load(image)
                    .into(binding.imageCard)
            }

        }

    }


}