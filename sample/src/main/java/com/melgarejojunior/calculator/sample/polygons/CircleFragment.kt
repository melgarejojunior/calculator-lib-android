package com.melgarejojunior.calculator.sample.polygons

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.polygons.Circle
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.databinding.FragmentCircleBinding
import com.melgarejojunior.calculator.sample.utils.BaseFragment


class CircleFragment : BaseFragment(R.layout.fragment_circle) {

    override val label: String get() = "Circle"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentCircleBinding.inflate(inflater, container, false).apply {
            inputDiameter.addTextChangedListener { text: Editable? ->
                val diameter = text?.toString()?.toDoubleOrNull() ?: 0.0
                val circle = Circle.fromDiameter(diameter)
                onContinueClicked(circle)
            }
        }.root
    }

    companion object {

        private var onContinueClicked: (Polygon) -> Unit = {}
        fun newInstance(handler: (Polygon) -> Unit): CircleFragment {
            onContinueClicked = handler
            return CircleFragment()
        }
    }
}