package com.github.satoshun.example.main.emojibreak

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import com.facebook.testing.screenshot.Screenshot
import com.github.satoshun.example.test.TestActivity
import org.junit.Test

class EmojiBreakTest {

  @Test
  fun break_test1() {
    val activityScenario = ActivityScenario.launch(TestActivity::class.java)
    activityScenario.onActivity { activity ->
      activity.emoji1.text = "たなかさん、こんにてゃ！こちらこそどんな😌"
    }

    activityScenario.onActivity { activity ->
      Screenshot.snapActivity(activity)
        .setName("break_test1")
        .record()
    }
  }

  @Test
  fun break_test2() {
    val scenario = launchFragmentInContainer<EmojiBreakFragment>()
    scenario.onFragment { fragment ->
      Screenshot.snap(fragment.view)
        .setName("break_test2")
        .record()
    }
  }

  @Test
  fun break_test3() {
    val scenario = launchFragmentInContainer<EmojiBreakFragment2>()
    scenario.onFragment { fragment ->
      Screenshot.snap(fragment.view)
        .setName("break_test3")
        .record()
    }
  }
}
