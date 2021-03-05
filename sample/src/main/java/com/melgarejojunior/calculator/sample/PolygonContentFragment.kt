package com.melgarejojunior.calculator.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.sample.databinding.FragmentPolygonContentBinding
import com.melgarejojunior.calculator.sample.polygons.CircleFragment
import com.melgarejojunior.calculator.sample.polygons.RectangleFragment
import com.melgarejojunior.calculator.sample.polygons.SquareFragment
import com.melgarejojunior.calculator.sample.polygons.TrapeziumFragment
import com.melgarejojunior.calculator.sample.polygons.TriangleFragment
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class PolygonContentFragment : Fragment() {

    private lateinit var binding: FragmentPolygonContentBinding
    private val items = ArrayList<BaseFragment>().apply {
        add(CircleFragment.newInstance(::handlePolygonResult))
        add(RectangleFragment.newInstance(::handlePolygonResult))
        add(SquareFragment.newInstance(::handlePolygonResult))
        add(TrapeziumFragment.newInstance(::handlePolygonResult))
        add(TriangleFragment.newInstance(::handlePolygonResult))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPolygonContentBinding.inflate(layoutInflater)
        setupSpinner()
        return binding.root
    }

    private fun handlePolygonResult(polygon: Polygon) {
        with(binding) {
            areaValue.text = "${polygon.area()}"
            perimeterValue.text = "${polygon.perimeter()}"
        }
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items.map { it.label })
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val fragment = items[p2]
                binding.areaValue.text = ""
                binding.perimeterValue.text = ""
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    companion object {
        fun newInstance() = PolygonContentFragment()
    }
}