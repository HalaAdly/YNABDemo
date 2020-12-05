package com.hm.ynabdemo.data.dto.budgets

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hm.ynabdemo.data.dto.shared.CurrencyFormat
import com.hm.ynabdemo.data.dto.shared.DateFormat
import kotlinx.parcelize.Parcelize

@Parcelize
class BudgetItem : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("last_modified_on")
    @Expose
    var lastModifiedOn: String? = null

    @SerializedName("first_month")
    @Expose
    var firstMonth: String? = null

    @SerializedName("last_month")
    @Expose
    var lastMonth: String? = null

    @SerializedName("date_format")
    @Expose
    var dateFormat: DateFormat? = null

    @SerializedName("currency_format")
    @Expose
    var currencyFormat: CurrencyFormat? = null




}