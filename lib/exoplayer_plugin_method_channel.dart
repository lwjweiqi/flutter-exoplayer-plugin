import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'exoplayer_plugin_platform_interface.dart';

/// An implementation of [ExoplayerPluginPlatform] that uses method channels.
class MethodChannelExoplayerPlugin extends ExoplayerPluginPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('exoplayer_plugin');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
