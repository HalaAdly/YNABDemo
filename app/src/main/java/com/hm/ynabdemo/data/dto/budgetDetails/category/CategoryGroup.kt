package com.hm.ynabdemo.data.dto.budgetDetails.category

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CategoryGroup {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("hidden")
    @Expose
    var hidden: Boolean? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null
}
