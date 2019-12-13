package com.github.satoshun.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import androidx.emoji.widget.EmojiAppCompatTextView
import com.github.satoshun.example.R

class TestActivity : AppCompatActivity() {
  lateinit var emoji1: EmojiAppCompatTextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.test_act)
    emoji1 = findViewById(R.id.emoji1)
  }
}
