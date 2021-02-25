package com.melgarejojunior.calculator.sample.polygons

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.polygons.Trapezium
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.databinding.FragmentTrapeziumBinding
import com.melgarejojunior.calculator.sample.utils.BaseFragment


class TrapeziumFragment : BaseFragment(R.layout.fragment_trapezium) {

    override val label: String get() = "Trapezium"
    private var trapezium = Trapezium(0.0, 0.0, 0.0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentTrapeziumBinding.inflate(inflater).apply {
            inputMaxBase.addTextChangedListener { text: Editable? ->
                val h = text?.toString()?.toDoubleOrNull() ?: 0.0
                trapezium = trapezium.copy(h = h)
                updateValues()
            }
            inputMinBase.addTextChangedListener { text: Editable? ->
                val minBase = text?.toString()?.toDoubleOrNull() ?: 0.0
                trapezium = trapezium.copy(minBase = minBase)
                updateValues()
            }
            inputHeight.addTextChangedListener { text: Editable? ->
                val maxBase = text?.toString()?.toDoubleOrNull() ?: 0.0
                trapezium = trapezium.copy(maxBase = maxBase)
                updateValues()
            }
        }.root
    }

    private fun updateValues() {
        onContinueClicked(trapezium)
    }

    companion object {

        private var onContinueClicked: (Polygon) -> Unit = {}
        fun newInstance(handler: (Polygon) -> Unit): TrapeziumFragment {
            onContinueClicked = handler
            return TrapeziumFragment()
        }
    }
}