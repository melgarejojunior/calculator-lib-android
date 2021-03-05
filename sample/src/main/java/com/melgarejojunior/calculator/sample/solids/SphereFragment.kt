package com.melgarejojunior.calculator.sample.solids

import com.melgarejojunior.calculator.lib.geometry.Solid
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class SphereFragment : BaseFragment(R.layout.fragment_sphere) {

    override val label: String get() = "Sphere"

    companion object {

        private var onContinueClicked: (Solid) -> Unit = {}
        fun newInstance(handler: (Solid) -> Unit): SphereFragment {
            onContinueClicked = handler
            return SphereFragment()
        }
    }
}