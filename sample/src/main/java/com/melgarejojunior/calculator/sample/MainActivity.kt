package com.melgarejojunior.calculator.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.melgarejojunior.calculator.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.contentMain.button2dOperation.setOnClickListener {
            openActivity(PolygonActivity.createIntent(this))
        }
        binding.contentMain.button3dOperation.setOnClickListener { }
        binding.contentMain.buttonLinearSystemOperation.setOnClickListener { }
    }

    private fun openActivity(intent: Intent) {
        startActivity(intent)
    }
}