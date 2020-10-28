package com.example.testzone.devbyte.ui

import com.example.testzone.devbyte.domain.DevByteVideo

/**
 * Click listener for Videos. By giving the block a name it helps a reader understand what it does.
 *
 */
class VideoClickListener(val block: (DevByteVideo) -> Unit) {
    /**
     * Called when a video is clicked
     *
     * @param video the video that was clicked
     */
    fun onClick(video: DevByteVideo) = block(video)
}