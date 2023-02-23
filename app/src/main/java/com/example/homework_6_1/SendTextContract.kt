package com.example.homework_6_1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.homework_6_1.Key.TEXT_KEY

class SendTextContract : ActivityResultContract<CharSequence?, CharSequence?>() {
    override fun createIntent(context: Context, input: CharSequence?): Intent {
        return Intent(context, SecondActivity::class.java)
            .putExtra(TEXT_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CharSequence? {
        intent ?: return null
        if (resultCode != Activity.RESULT_OK) return null

        return intent.getCharSequenceExtra(TEXT_KEY)
    }
}