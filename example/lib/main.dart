import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:exoplayer_plugin/exoplayer_plugin.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final _exoplayerPlugin = ExoplayerPlugin();

  @override
  void initState() {
    super.initState();
  }

  Future<void> initializePlayer() async {
    try {
      await ExoplayerPlugin.initializePlayer();
      await ExoplayerPlugin.setUrl("https://vsp-stream.s3.ap-northeast-1.amazonaws.com/HLS/raw/SpaceX.m3u8");
      // 播放器已成功初始化
    } catch (e) {
      // 处理初始化播放器错误
    }
  }

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('MlyPlayer'),
        ),
        body: Column(
          children: [
            Center(
                child: Container(
                width: 300,
                height: 200,
                child: const AndroidView(
                  viewType: 'exoplayer_flutter_plugin/StyledPlayerView',
                  creationParams: {
                    'url': 'https://vsp-stream.s3.ap-northeast-1.amazonaws.com/HLS/raw/SpaceX.m3u8',
                  },
                  creationParamsCodec: StandardMessageCodec(),),
                )
            ),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  // 按钮点击事件
                  ExoplayerPlugin.play();
                },
                child: const Text('play'),
              ),
            ),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  // 按钮点击事件
                  ExoplayerPlugin.pause();
                },
                child: const Text('pause'),
              ),
            )
          ],

        ),
      ),
    );
  }
}
