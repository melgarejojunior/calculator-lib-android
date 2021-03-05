package com.melgarejojunior.calculator.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.melgarejojunior.calculator.lib.geometry.Solid
import com.melgarejojunior.calculator.sample.databinding.ActivitySolidBinding
import com.melgarejojunior.calculator.sample.solids.PrismFragment
import com.melgarejojunior.calculator.sample.solids.PyramidFragment
import com.melgarejojunior.calculator.sample.solids.SphereFragment
import com.melgarejojunior.calculator.sample.utils.BaseFragment

class SolidActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySolidBinding
    private val items = ArrayList<BaseFragment>().apply {
        add(SphereFragment.newInstance(::handleSolidResult))
        add(PyramidFragment.newInstance(::handleSolidResult))
        add(PrismFragment.newInstance(::handleSolidResult))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolidBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        setupSpinner()
    }

    private fun handleSolidResult(solid: Solid) {
        with(binding) {
            volumeValue.text = "${solid.volume()}"
        }
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items.map { it.label })
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val fragment = items[p2]
                binding.volumeValue.text = ""
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
        fun createIntent(context: Context) = Intent(context, SolidActivity::class.java)
    }
}