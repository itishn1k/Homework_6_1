package com.example.homework_6_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val getText = registerForActivityResult(SendTextContract()) {
        binding.etFirst.setText(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.btnNext.setOnClickListener {
            if (binding.etFirst.text.isNotEmpty()) {
                getText.launch(binding.etFirst.text)
            } else {
                toastShort(this, getString(R.string.field_is_empty))
            }
        }
    }
}