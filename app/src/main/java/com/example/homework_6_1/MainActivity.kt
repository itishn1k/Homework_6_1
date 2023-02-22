package com.example.homework_6_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_6_1.Key.TEXT_KEY
import com.example.homework_6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        initLauncher()
        setData()
    }

    private fun initClickers() {
        binding.btnNext.setOnClickListener {
            if (binding.etFirst.text.isNotEmpty()) {
                transferData()
            } else {
                toastShort(this, getString(R.string.field_is_empty))
            }
        }
    }

    private fun transferData() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(TEXT_KEY, binding.etFirst.text.toString())
        resultLauncher.launch(intent)
    }

    private fun initLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.etFirst.setText(result.data?.getStringExtra(TEXT_KEY))
                }
            }
    }

    private fun setData() {
        binding.etFirst.setText(intent.getStringExtra(TEXT_KEY))
    }
}