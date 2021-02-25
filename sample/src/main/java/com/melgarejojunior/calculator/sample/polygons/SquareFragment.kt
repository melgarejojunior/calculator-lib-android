package com.melgarejojunior.calculator.sample.polygons

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.polygons.Square
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.databinding.FragmentSquareBinding
import com.melgarejojunior.calculator.sample.utils.BaseFragment


class SquareFragment : BaseFragment(R.layout.fragment_square) {

    override val label: String get() = "Square"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentSquareBinding.inflate(inflater).apply {
            inputBase.addTextChangedListener { text: Editable? ->
                val side = text?.toString()?.toDoubleOrNull() ?: 0.0
                val square = Square(l = side)
                onContinueClicked(square)
            }
        }.root
    }

    companion object {

        private var onContinueClicked: (Polygon) -> Unit = {}
        fun newInstance(handler: (Polygon) -> Unit): SquareFragment {
            onContinueClicked = handler
            return SquareFragment()
        }
    }
}