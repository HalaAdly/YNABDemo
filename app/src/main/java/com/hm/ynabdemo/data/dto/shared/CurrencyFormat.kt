package com.hm.ynabdemo.data.dto.shared

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class CurrencyFormat : Parcelable {
    @SerializedName("iso_code")
    @Expose
    var isoCode: String? = null

    @SerializedName("example_format")
    @Expose
    var exampleFormat: String? = null

    @SerializedName("decimal_digits")
    @Expose
    var decimalDigits: Int? = null

    @SerializedName("decimal_separator")
    @Expose
    var decimalSeparator: String? = null

    @SerializedName("symbol_first")
    @Expose
    var symbolFirst: Boolean? = null

    @SerializedName("group_separator")
    @Expose
    var groupSeparator: String? = null

    @SerializedName("currency_symbol")
    @Expose
    var currencySymbol: String? = null

    @SerializedName("display_symbol")
    @Expose
    var displaySymbol: Boolean? = null
}