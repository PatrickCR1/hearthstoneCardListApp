package com.example.hearthstonelist.ui.view.fragments

class AllCardsListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.list()
    }
}
