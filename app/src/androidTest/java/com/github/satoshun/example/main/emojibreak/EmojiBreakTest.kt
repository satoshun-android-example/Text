package com.github.satoshun.example.main.emojibreak

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.satoshun.example.test.TestActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmojiBreakTest {

  @Test
  fun break_test1() {
    val activityScenario = ActivityScenario.launch(TestActivity::class.java)
    activityScenario.onActivity { activity ->
      activity.emoji1.text = "たなかさん、こんにてゃ！こちらこそどんな😌"
    }

    Thread.sleep(3000)
  }
}
