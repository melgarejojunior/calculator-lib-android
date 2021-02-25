package com.melgarejojunior.calculator.sample.polygons

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.polygons.Triangle
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.databinding.FragmentTriangleBinding
import com.melgarejojunior.calculator.sample.utils.BaseFragment


class TriangleFragment : BaseFragment(R.layout.fragment_triangle) {

    override val label: String get() = "Triangle"
    private var triangle = Triangle(0.0, 0.0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentTriangleBinding.inflate(inflater).apply {
            inputBase.addTextChangedListener { text: Editable? ->
                val base = text?.toString()?.toDoubleOrNull() ?: 0.0
                triangle = Triangle(height = triangle.height, base = base)
                onContinueClicked(triangle)

            }
            inputHeight.addTextChangedListener { text: Editable? ->
                val height = text?.toString()?.toDoubleOrNull() ?: 0.0
                triangle = Triangle(height = height, base = triangle.base)
                onContinueClicked(triangle)

            }
        }.root
    }

    companion object {

        private var onContinueClicked: (Polygon) -> Unit = {}
        fun newInstance(handler: (Polygon) -> Unit): TriangleFragment {
            onContinueClicked = handler
            return TriangleFragment()
        }
    }
}