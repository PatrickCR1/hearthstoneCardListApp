package com.example.hearthstonelist.ui.ui.view.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.ui.ui.viewmodel.CardListViewModel

class WarlockFragment : Fragment() {

    // ViewModel & Binding
    private lateinit var viewModel: CardListViewModel

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProvider(this).get(CardListViewModel::class.java)
        viewModel.listClass(HSConstants.CLASS.WARLOCK)
    }
}
