package com.hm.ynabdemo.data.dto.budgetDetails.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Category : CategoryBase() {


    @SerializedName("category_group_id")
    @Expose
    var categoryGroupId: String? = null


    @SerializedName("original_category_group_id")
    @Expose
    var originalCategoryGroupId: String? = null

    @SerializedName("note")
    @Expose
    var note: String? = null

    @SerializedName("budgeted")
    @Expose
    var budgeted: String? = null

    @SerializedName("activity")
    @Expose
    var activity: Int? = null

    @SerializedName("balance")
    @Expose
    var balance: String? = null

    @SerializedName("goal_type")
    @Expose
    var goalType: String? = null

    @SerializedName("goal_creation_month")
    @Expose
    var goalCreationMonth: String? = null

    @SerializedName("goal_target")
    @Expose
    var goalTarget: Int? = null

    @SerializedName("goal_target_month")
    @Expose
    var goalTargetMonth: String? = null

    @SerializedName("goal_percentage_complete")
    @Expose
    var goalPercentageComplete: Int? = null

}