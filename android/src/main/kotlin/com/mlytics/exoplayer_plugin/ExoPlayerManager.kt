package com.mlytics.exoplayer_plugin

import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource

class ExoPlayerManager (private val context: Context){
    private var exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    fun setMediaSource(mediaSource:MediaSource) {
        exoPlayer.setMediaSource(mediaSource)
        var mediaItem: MediaItem = MediaItem.fromUri("https://vsp-stream.s3.ap-northeast-1.amazonaws.com/HLS/raw/SpaceX.m3u8")
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.playWhenReady = true
        exoPlayer.prepare()
    }

    fun getPlayer(): ExoPlayer {
        return exoPlayer
    }

    fun releasePlayer() {
        exoPlayer.release()
    }

    fun play() {
        exoPlayer.stop()
    }

    fun pause() {
        exoPlayer.stop()
    }
}