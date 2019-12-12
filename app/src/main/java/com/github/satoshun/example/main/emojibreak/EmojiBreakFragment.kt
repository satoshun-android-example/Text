package com.github.satoshun.example.main.emojibreak

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.EmojiBreakFragBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EmojiBreakFragment : Fragment(R.layout.emoji_break_frag) {
  private lateinit var binding: EmojiBreakFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = EmojiBreakFragBinding.bind(view)

    binding.emoji1.text = "testtest😌😌😌😌😌😌"
    binding.emoji2.text = "testtest😌😌😌😌😌😌"
    binding.emoji3.text = "testtest😌😌😌😌😌😌"
    binding.emoji4.text = "たなかさん、こんにてゃ！こちらこそどんな😌"
    binding.emoji5.text = "たなかさん、こんにてゃ！こちらこそどんな😌"
    binding.emoji6.text = "たなかさん、こんにてゃ！こちらこそどんな😌"
    binding.emoji7.text = "testtesttesttesttesttest"
    binding.emoji8.text = "たなかさん、😌\uD83D\uDE0Cこんにてゃ！こちらこそどんな😌"
    binding.emoji9.text = "たなかさん、😌こんにてゃ！こちらこそどんな😌aa"

    binding.emoji10.isSelected = true
    binding.emoji10.text = "たなかさん、😌こんにてゃ！こちらこそどんな😌"

    binding.emoji11.text = "たなかさん、😌こんにてゃ！こちらこそどんな😌"
    binding.emoji12.text = "たなかさん、😌こんにてゃ！こちらこそどんな😌"
    lifecycleScope.launch {
      delay(1000)
      binding.emoji12.ellipsize = null
    }

    lifecycleScope.launch {
      binding.emoji13.setTextWithStripOverflowText("たなかさん、😌😌こんに😌てゃ！こちらこそどんな😌")

      delay(1000)

      binding.emoji13.setTextWithStripOverflowText("たなさん、😌😌こんに😌てゃ！こちらこそどん😌")
    }
  }
}
