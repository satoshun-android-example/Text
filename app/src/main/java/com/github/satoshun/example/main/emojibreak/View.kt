package com.github.satoshun.example.main.emojibreak

import android.view.View
import android.widget.TextView
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun TextView.setTextWithStripOverflowText(newText: String) {
  // fast pass
  val currentText = text
  val currentEndIndex = layout?.getEllipsisStart(0)
  if (currentEndIndex != null && newText.subSequence(0, currentEndIndex) == currentText) {
    return
  }

  text = newText
  awaitNextLayout()

  val newEndIndex = layout?.getEllipsisStart(0) ?: return
  text = text.subSequence(0, newEndIndex + 2)
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
