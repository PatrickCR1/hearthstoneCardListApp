package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class RogueCardListFragment : BaseCardListFragment() {


    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.ROGUE)
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.ROGUE_IMAGE, binding.imageClass, HSConstants.IMAGE.IMAGE_WIDTH, HSConstants.IMAGE.IMAGE_HEIGHT)
    }
}
