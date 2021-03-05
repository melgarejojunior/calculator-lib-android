package com.melgarejojunior.calculator.sample.solids

import com.melgarejojunior.calculator.lib.geometry.Solid
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class PyramidFragment : BaseFragment(R.layout.fragment_pyramid) {

    override val label: String get() = "Pyramid"

    companion object {

        private var onContinueClicked: (Solid) -> Unit = {}
        fun newInstance(handler: (Solid) -> Unit): PyramidFragment {
            onContinueClicked = handler
            return PyramidFragment()
        }
    }
}