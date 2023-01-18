package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class DemonHunterCardListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.DEMON_HUNTER)
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.DEMON_HUNTER_IMAGE, binding.imageClass, HSConstants.IMAGE.IMAGE_WIDTH, HSConstants.IMAGE.IMAGE_HEIGHT)
    }
}
