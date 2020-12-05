package com.hm.ynabdemo.data.dto.budgets

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class BudgetsResponse(@SerializedName("data")
                           @Expose var data: Data?) : Parcelable {
    @Parcelize
    class Data : Parcelable {
        @SerializedName("budgets")
        @Expose
        var budgets: ArrayList<BudgetItem>? = null

        @SerializedName("default_budget")
        @Expose
        var defaultBudget: BudgetItem? = null
    }
}

