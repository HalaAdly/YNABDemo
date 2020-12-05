package com.hm.ynabdemo.data.dto.budgetDetails.transactions

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class ScheduledTransaction {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("date_first")
    @Expose
    var dateFirst: String? = null

    @SerializedName("date_next")
    @Expose
    var dateNext: String? = null

    @SerializedName("frequency")
    @Expose
    var frequency: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Int? = null

    @SerializedName("memo")
    @Expose
    var memo: String? = null

    @SerializedName("flag_color")
    @Expose
    var flagColor: String? = null

    @SerializedName("account_id")
    @Expose
    var accountId: String? = null

    @SerializedName("payee_id")
    @Expose
    var payeeId: String? = null

    @SerializedName("category_id")
    @Expose
    var categoryId: String? = null

    @SerializedName("transfer_account_id")
    @Expose
    var transferAccountId: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}
