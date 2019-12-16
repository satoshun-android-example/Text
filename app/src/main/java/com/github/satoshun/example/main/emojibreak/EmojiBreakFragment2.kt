package com.github.satoshun.example.main.emojibreak

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.EmojiBreakFrag2Binding
import kotlinx.coroutines.launch

class EmojiBreakFragment2 : Fragment(R.layout.emoji_break_frag2) {
  private lateinit var binding: EmojiBreakFrag2Binding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = EmojiBreakFrag2Binding.bind(view)

    lifecycleScope.launch {
      binding.emoji1.setTextWithStripOverflowText("testtest😌😌😌😌😌😌")
      binding.emoji2.setTextWithStripOverflowText("testtestあ😌😌😌😌😌😌")
      binding.emoji3.setTextWithStripOverflowText("testtestああ😌😌😌😌😌😌")
      binding.emoji4.setTextWithStripOverflowText("testtestあああ😌😌😌😌😌😌")
      binding.emoji5.setTextWithStripOverflowText("testtestああああ😌😌😌😌😌😌")
    }
  }
}
