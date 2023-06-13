package com.mlytics.exoplayer_plugin

import android.content.Context
import android.net.Uri
import android.view.View
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class MlyStyledPlayerViewFactory(private val messenger: BinaryMessenger) :
    PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    private var exoPlayerManager: ExoPlayerManager? = null

    override fun create(context: Context, id: Int, args: Any?): PlatformView {
        val params = args as? HashMap<*, *>
        val url = params?.get("url") as? String

        val styledPlayerView = StyledPlayerView(context)
        exoPlayerManager = ExoPlayerManager(context)

        styledPlayerView.player = exoPlayerManager?.getPlayer()

        // 设置StyledPlayerView的样式和配置

        if (url != null) {
            val dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "ExoPlayer"))
            val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(url))

            exoPlayerManager!!.setMediaSource(mediaSource)
        }

        return object : PlatformView {
            override fun getView(): View {
                return styledPlayerView
            }

            override fun dispose() {
                styledPlayerView.player?.release()
            }
        }
    }

    fun play() {
        exoPlayerManager?.play()
    }

    fun pause() {
        exoPlayerManager?.pause()
    }
}

