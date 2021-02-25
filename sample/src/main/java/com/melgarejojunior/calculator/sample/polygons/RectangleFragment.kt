package com.melgarejojunior.calculator.sample.polygons

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.lib.geometry.polygons.Rectangle
import com.melgarejojunior.calculator.sample.R
import com.melgarejojunior.calculator.sample.databinding.FragmentRectangleBinding
import com.melgarejojunior.calculator.sample.utils.BaseFragment


class RectangleFragment : BaseFragment(R.layout.fragment_rectangle) {

    override val label: String get() = "Rectangle"

    private var rectangle = Rectangle(0.0, 0.0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentRectangleBinding.inflate(inflater).apply {
            inputBase.addTextChangedListener { text: Editable? ->
                rectangle = rectangle.copy(b = text?.toString()?.toDoubleOrNull() ?: 0.0)
                updateValues()
            }
            inputHeight.addTextChangedListener { text: Editable? ->
                rectangle = rectangle.copy(h = text?.toString()?.toDoubleOrNull() ?: 0.0)
                updateValues()
            }
        }.root
    }

    private fun updateValues() {
        onContinueClicked(rectangle)
    }

    companion object {
        private var onContinueClicked: (Polygon) -> Unit = {}
        fun newInstance(handler: (Polygon) -> Unit): RectangleFragment {
            onContinueClicked = handler
            return RectangleFragment()
        }
    }
}