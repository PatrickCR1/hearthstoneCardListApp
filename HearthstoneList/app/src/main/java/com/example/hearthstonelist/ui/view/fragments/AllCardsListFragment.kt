package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class AllCardsListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.list()
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.HEARTHSTONE_IMAGE, binding.imageClass, HSConstants.IMAGE.LOGO_IMAGE_WIDTH, HSConstants.IMAGE.LOGO_IMAGE_HEIGHT)
    }
}
