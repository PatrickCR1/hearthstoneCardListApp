package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class ShamanCardListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.SHAMAN)
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.SHAMAN_IMAGE, binding.imageClass, HSConstants.IMAGE.IMAGE_WIDTH, HSConstants.IMAGE.IMAGE_HEIGHT)
    }
}
