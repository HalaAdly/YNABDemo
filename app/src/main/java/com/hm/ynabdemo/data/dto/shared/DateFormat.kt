package com.hm.ynabdemo.data.dto.shared

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class DateFormat : Parcelable {
    @SerializedName("format")
    @Expose
    var format: String? = null
}