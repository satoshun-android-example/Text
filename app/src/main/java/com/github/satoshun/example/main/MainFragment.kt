package com.github.satoshun.example.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.MainFragBinding

class MainFragment : Fragment(R.layout.main_frag) {
  private lateinit var binding: MainFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = MainFragBinding.bind(view)

    binding.emojiBreak.setOnClickListener {
      findNavController().navigate(MainFragmentDirections.navHomeToEmojiBreak())
    }

    binding.emojiBreak2.setOnClickListener {
      findNavController().navigate(MainFragmentDirections.navHomeToEmojiBreak2())
    }
  }
}
