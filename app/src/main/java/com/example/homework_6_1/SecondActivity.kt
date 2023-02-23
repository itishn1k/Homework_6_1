package com.example.homework_6_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_6_1.Key.TEXT_KEY
import com.example.homework_6_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.etSecond.setText(intent.getCharSequenceExtra(TEXT_KEY))
        binding.btnBack.setOnClickListener {
            if (binding.etSecond.text.isNotEmpty()) {
                sendResult()
            } else {
                toastShort(this, getString(R.string.field_is_empty))
            }
        }
    }

    private fun sendResult() {
        val data = Intent().putExtra(TEXT_KEY, binding.etSecond.text as CharSequence)
        setResult(RESULT_OK, data)
        finish()
    }
}