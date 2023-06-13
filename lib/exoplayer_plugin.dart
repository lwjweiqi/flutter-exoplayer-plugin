
import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';

import 'exoplayer_plugin_platform_interface.dart';

class ExoplayerPlugin {

  static const MethodChannel _channel = MethodChannel('exoplayer_plugin');

  static Future<void> initializePlayer() async {
    try {
      await _channel.invokeMethod('initializePlayer');
    } catch (e) {
      // 处理错误
    }
  }

  static Future<void> setUrl(String url) async {
    try {
      await _channel.invokeMethod('setUrl', {'url': url});
    } catch (e) {
      print('Error playing: $e');
    }
  }

  static Future<void> pause() async {
    try {
      await _channel.invokeMethod('pause');
    } catch (e) {
      print('Error pause: $e');
    }
  }
  static Future<void> play() async {
    try {
      await _channel.invokeMethod('play');
    } catch (e) {
      print('Error pause: $e');
    }
  }

}

