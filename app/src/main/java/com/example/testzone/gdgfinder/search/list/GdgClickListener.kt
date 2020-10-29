package com.example.testzone.gdgfinder.search.list

import com.example.testzone.gdgfinder.network.models.GdgChapter

class GdgClickListener (val action: (chapter: GdgChapter) -> Unit) {
    fun onGdgClick(chapter: GdgChapter) = action(chapter)
}