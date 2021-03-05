package com.melgarejojunior.calculator.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.melgarejojunior.calculator.sample.databinding.ActivityPolygonBinding

class PolygonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPolygonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPolygonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        openFragment()
    }

    private fun openFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PolygonContentFragment.newInstance())
            .commit()
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