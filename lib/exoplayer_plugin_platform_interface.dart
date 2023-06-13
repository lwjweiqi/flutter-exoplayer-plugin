import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'exoplayer_plugin_method_channel.dart';

abstract class ExoplayerPluginPlatform extends PlatformInterface {
  /// Constructs a ExoplayerPluginPlatform.
  ExoplayerPluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static ExoplayerPluginPlatform _instance = MethodChannelExoplayerPlugin();

  /// The default instance of [ExoplayerPluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelExoplayerPlugin].
  static ExoplayerPluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [ExoplayerPluginPlatform] when
  /// they register themselves.
  static set instance(ExoplayerPluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
