package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class MageCardListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.MAGE)
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.MAGE_IMAGE, binding.imageClass, HSConstants.IMAGE.IMAGE_WIDTH, HSConstants.IMAGE.IMAGE_HEIGHT)
    }
}
