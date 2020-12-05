package com.hm.ynabdemo.data.dto.budgetDetails.payee

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Payee {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("transfer_account_id")
    @Expose
    var transferAccountId: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}
