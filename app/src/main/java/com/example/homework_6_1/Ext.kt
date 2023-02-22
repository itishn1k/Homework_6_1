package com.example.homework_6_1

import android.content.Context
import android.widget.Toast

fun toastShort(context: Context, setText: String) {
    Toast.makeText(context, setText, Toast.LENGTH_SHORT).show()
}