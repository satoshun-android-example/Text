/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.satoshun.example.main.emojibreak

import android.view.View
import android.widget.TextView
import androidx.core.view.OneShotPreDrawListener
import androidx.emoji.text.EmojiCompat
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun TextView.setTextWithStripOverflowText(newText: String) {
  if (text == newText) return

  text = newText
  awaitPreDraw()

  val newEndIndex = layout?.getEllipsisStart(0) ?: return
  if (newEndIndex == 0) return
  if (text.length < newEndIndex + 2) return

  if (EmojiCompat.get().hasEmojiGlyph(text.substring(newEndIndex, newEndIndex + 2))) {
    // remove end of emoji and force ellipsis
    text = "${text.subSequence(0, newEndIndex)}…"
    return
  }
}

suspend fun View.awaitPreDraw() = suspendCancellableCoroutine<Unit> { cont ->
  val listener = OneShotPreDrawListener.add(this) {
    cont.resume(Unit)
  }
  // If the coroutine is cancelled, remove the listener
  cont.invokeOnCancellation {
    listener.removeListener()
  }
}

suspend fun View.awaitNextLayout() = suspendCancellableCoroutine<Unit> { cont ->
  val listener = object : View.OnLayoutChangeListener {
    override fun onLayoutChange(
      view: View,
      left: Int,
      top: Int,
      right: Int,
      bottom: Int,
      oldLeft: Int,
      oldTop: Int,
      oldRight: Int,
      oldBottom: Int
    ) {
      // Remove the listener
      view.removeOnLayoutChangeListener(this)
      // And resume the continuation
      cont.resume(Unit)
    }
  }
  // If the coroutine is cancelled, remove the listener
  cont.invokeOnCancellation { removeOnLayoutChangeListener(listener) }
  // And finally add the listener to view
  addOnLayoutChangeListener(listener)
}
