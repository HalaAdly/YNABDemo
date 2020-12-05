package com.hm.ynabdemo.data.dto.budgetDetails.transactions

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Subtransaction {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("transaction_id")
    @Expose
    var transactionId: String? = null

    @SerializedName("amount")
    @Expose
    var amount: Int? = null

    @SerializedName("memo")
    @Expose
    var memo: String? = null

    @SerializedName("payee_id")
    @Expose
    var payeeId: String? = null

    @SerializedName("payee_name")
    @Expose
    var payeeName: String? = null

    @SerializedName("category_id")
    @Expose
    var categoryId: String? = null

    @SerializedName("category_name")
    @Expose
    var categoryName: String? = null

    @SerializedName("transfer_account_id")
    @Expose
    var transferAccountId: String? = null

    @SerializedName("transfer_transaction_id")
    @Expose
    var transferTransactionId: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}
