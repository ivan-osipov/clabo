package com.github.ivan_osipov.clabo.api.model

import com.google.gson.annotations.SerializedName

class File : AbstractFileDescriptor() {

    @SerializedName("file_path")
    var filePath: String? = null

}