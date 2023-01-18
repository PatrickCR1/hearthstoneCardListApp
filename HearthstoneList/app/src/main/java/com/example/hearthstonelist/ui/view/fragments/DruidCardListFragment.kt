package com.example.hearthstonelist.ui.view.fragments

import com.example.hearthstonelist.service.constants.HSConstants
import com.example.hearthstonelist.service.image.ImageService

class DruidCardListFragment : BaseCardListFragment() {

    override fun onResume() {
        super.onResume()
        viewModel.listClass(HSConstants.CLASS.DRUID)
        ImageService.loadImage(requireContext(), HSConstants.IMAGE.DRUID_IMAGE, binding.imageClass, HSConstants.IMAGE.IMAGE_WIDTH, HSConstants.IMAGE.IMAGE_HEIGHT)
    }
}
