package com.github.satoshun.example.test

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.facebook.litho.config.ComponentsConfiguration
import com.facebook.testing.screenshot.ScreenshotRunner
import com.facebook.testing.screenshot.layouthierarchy.LayoutHierarchyDumper
import com.facebook.testing.screenshot.layouthierarchy.common.TextViewAttributePlugin
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoAttributePlugin
import com.facebook.testing.screenshot.layouthierarchy.litho.LithoHierarchyPlugin

class ScreenshotTestRunner : AndroidJUnitRunner() {
  companion object {
    init {
      LayoutHierarchyDumper.addGlobalAttributePlugin(TextViewAttributePlugin.getInstance())

      ComponentsConfiguration.isDebugModeEnabled = true
      LayoutHierarchyDumper.addGlobalHierarchyPlugin(LithoHierarchyPlugin.getInstance())
      LayoutHierarchyDumper.addGlobalAttributePlugin(LithoAttributePlugin.getInstance())
    }
  }

  override fun onCreate(arguments: Bundle) {
    ScreenshotRunner.onCreate(this, arguments)
    super.onCreate(arguments)
  }

  override fun finish(resultCode: Int, results: Bundle) {
    ScreenshotRunner.onDestroy()
    super.finish(resultCode, results)
  }
}

