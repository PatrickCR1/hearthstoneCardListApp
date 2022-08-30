package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants

class WarriorCardListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.WARRIOR)
    }
}
