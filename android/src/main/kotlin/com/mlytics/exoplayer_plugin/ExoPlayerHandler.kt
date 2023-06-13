package com.mlytics.exoplayer_plugin

import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class ExoPlayerHandler(context: Context) {
    private var player = ExoPlayerManager(context)

    fun initializePlayer() {

    }

    fun releasePlayer() {
        player?.releasePlayer()
    }

    fun play() {
        player?.play()
    }

    fun pause() {
        player?.pause()
    }

}