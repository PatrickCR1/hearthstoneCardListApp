package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants

class RogueCardListFragment : BaseCardListFragment() {


    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.ROGUE)
    }
}
