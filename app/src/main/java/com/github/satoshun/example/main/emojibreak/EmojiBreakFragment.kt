package com.github.satoshun.example.main.emojibreak

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.EmojiBreakFragBinding

class EmojiBreakFragment : Fragment(R.layout.emoji_break_frag) {
  private lateinit var binding: EmojiBreakFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = EmojiBreakFragBinding.bind(view)

    binding.emoji1.text = "test"
  }
}
