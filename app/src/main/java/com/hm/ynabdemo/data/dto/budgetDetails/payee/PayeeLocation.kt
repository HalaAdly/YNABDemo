package com.hm.ynabdemo.data.dto.budgetDetails.payee

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class PayeeLocation {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("payee_id")
    @Expose
    var payeeId: String? = null

    @SerializedName("latitude")
    @Expose
    var latitude: String? = null

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}
