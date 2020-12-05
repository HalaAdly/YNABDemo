package com.hm.ynabdemo.data.dto.budgetDetails.transactions

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Transaction {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Int? = null

    @SerializedName("memo")
    @Expose
    var memo: String? = null

    @SerializedName("cleared")
    @Expose
    var cleared: String? = null

    @SerializedName("approved")
    @Expose
    var approved: Boolean? = null

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

    @SerializedName("transfer_transaction_id")
    @Expose
    var transferTransactionId: String? = null

    @SerializedName("matched_transaction_id")
    @Expose
    var matchedTransactionId: String? = null

    @SerializedName("import_id")
    @Expose
    var importId: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}