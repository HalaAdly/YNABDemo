package com.hm.ynabdemo.data.dto.budgets

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Budgets( @SerializedName("list")
                    @Expose val list: ArrayList<BudgetItem>?) : Parcelable {
}