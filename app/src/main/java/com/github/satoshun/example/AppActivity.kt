package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import com.github.satoshun.example.databinding.AppActBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = AppActBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setSupportActionBar(binding.toolbar)

    val fontRequest = FontRequest(
      "com.google.android.gms.fonts",
      "com.google.android.gms",
      "Noto Color Emoji Compat",
      R.array.com_google_android_gms_fonts_certs
    )

    val config = FontRequestEmojiCompatConfig(this, fontRequest).setReplaceAll(true)
    EmojiCompat.init(config)
  }
}
