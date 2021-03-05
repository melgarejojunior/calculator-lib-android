package com.melgarejojunior.calculator.sample.solids

import com.melgarejojunior.calculator.lib.geometry.Solid
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class PrismFragment : BaseFragment(R.layout.fragment_prism) {

    override val label: String get() = "Prism"

    companion object {

        private var onContinueClicked: (Solid) -> Unit = {}
        fun newInstance(handler: (Solid) -> Unit): PrismFragment {
            onContinueClicked = handler
            return PrismFragment()
        }
    }
}