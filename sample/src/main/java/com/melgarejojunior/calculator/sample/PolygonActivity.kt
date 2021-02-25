package com.melgarejojunior.calculator.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.melgarejojunior.calculator.lib.geometry.Polygon
import com.melgarejojunior.calculator.sample.databinding.ActivityPolygonBinding
import com.melgarejojunior.calculator.sample.polygons.CircleFragment
import com.melgarejojunior.calculator.sample.polygons.RectangleFragment
import com.melgarejojunior.calculator.sample.polygons.SquareFragment
import com.melgarejojunior.calculator.sample.polygons.TrapeziumFragment
import com.melgarejojunior.calculator.sample.polygons.TriangleFragment
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class PolygonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPolygonBinding
    private val items = ArrayList<BaseFragment>().apply {
        add(CircleFragment.newInstance(::handlePolygonResult))
        add(RectangleFragment.newInstance(::handlePolygonResult))
        add(SquareFragment.newInstance(::handlePolygonResult))
        add(TrapeziumFragment.newInstance(::handlePolygonResult))
        add(TriangleFragment.newInstance(::handlePolygonResult))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolygonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        setupSpinner()
    }

    private fun handlePolygonResult(polygon: Polygon) {
        with(binding) {
            areaValue.text = "${polygon.area()}"
            perimeterValue.text = "${polygon.perimeter()}"
        }
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items.map { it.label })
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val fragment = items[p2]
                binding.areaValue.text = ""
                binding.perimeterValue.text = ""
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, PolygonActivity::class.java)
    }
}