package com.example.homework_6_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        initLauncher()
        setData()
    }

    private fun initClickers() {
        binding.btnBack.setOnClickListener {
            if (binding.etSecond.text.isNotEmpty()) {
                transferData()
            } else {
                toastShort(this, getString(R.string.field_is_empty))
            }
        }
    }

    private fun transferData() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Key.TEXT_KEY, binding.etSecond.text.toString())
        resultLauncher.launch(intent)
    }

    private fun initLauncher() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.etSecond.setText(result.data?.getStringExtra(Key.TEXT_KEY))
                }
            }
    }

    private fun setData() {
        binding.etSecond.setText(intent.getStringExtra(Key.TEXT_KEY))
    }
}