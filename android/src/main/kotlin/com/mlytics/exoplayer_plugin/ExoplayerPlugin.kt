package com.mlytics.exoplayer_plugin

import android.content.Context
import androidx.annotation.NonNull
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.StyledPlayerView

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.platform.PlatformViewRegistry

/** ExoplayerPlugin */
class ExoplayerPlugin: FlutterPlugin, MethodCallHandler {
  private lateinit var channel : MethodChannel
  private lateinit var playerHandler: ExoPlayerManager

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "exoplayer_plugin")
    channel.setMethodCallHandler(this)
    val messenger = flutterPluginBinding.binaryMessenger
    playerHandler = ExoPlayerManager(flutterPluginBinding.applicationContext)
    val platformViewRegistry = flutterPluginBinding.platformViewRegistry
    registerViewFactory(messenger, platformViewRegistry)
  }


  private fun registerViewFactory(messenger: BinaryMessenger, registry: PlatformViewRegistry) {
    val factory = MlyStyledPlayerViewFactory(messenger)
    registry.registerViewFactory("exoplayer_flutter_plugin/StyledPlayerView", factory)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    when(call.method) {
      "initializePlayer" -> {
        result.success(null)
      }
      "start" -> {
      }
      "stop" -> {
      }
      "play" -> {
        playerHandler.play()
      }
      "pause" -> {
        playerHandler.pause()
      }
      else -> result.notImplemented()
      // 其他与播放器相关的方法处理
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
    playerHandler.releasePlayer()
  }
}
