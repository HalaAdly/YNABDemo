package com.hm.ynabdemo.data.dto.budgetDetails

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class BudgetDetailsData {
    @SerializedName("budget")
    @Expose
    var budget: BudgetDetailsItem? = null

    @SerializedName("server_knowledge")
    @Expose
    var serverKnowledge: Int? = null
}
