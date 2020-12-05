package com.hm.ynabdemo.data.dto.budgetDetails

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class BudgetDetailsResponse {
    @SerializedName("data")
    @Expose
    var data: BudgetDetailsData? = null
}