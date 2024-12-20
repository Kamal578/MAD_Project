package com.example.deezerapp.ui.artist

import com.example.deezerapp.core.UiData

data class AlbumsUiData(
    override var id: Int,
    var title: String,
    var picture:String,
    var date:String
):UiData()