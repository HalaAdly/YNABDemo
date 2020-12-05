package com.hm.ynabdemo.data.dto.budgetDetails.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Month {
    @SerializedName("month")
    @Expose
    var month: String? = null

    @SerializedName("note")
    @Expose
    var note: String? = null

    @SerializedName("income")
    @Expose
    var income: Int? = null

    @SerializedName("budgeted")
    @Expose
    var budgeted: Int? = null

    @SerializedName("activity")
    @Expose
    var activity: Int? = null

    @SerializedName("to_be_budgeted")
    @Expose
    var toBeBudgeted: Int? = null

    @SerializedName("age_of_money")
    @Expose
    var ageOfMoney: Int? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null

    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
}