package com.hm.ynabdemo.data.dto.budgetDetails.transactions

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ScheduledSubtransaction {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("scheduled_transaction_id")
    @Expose
    var scheduledTransactionId: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Int? = null

    @SerializedName("memo")
    @Expose
    var memo: String? = null

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
