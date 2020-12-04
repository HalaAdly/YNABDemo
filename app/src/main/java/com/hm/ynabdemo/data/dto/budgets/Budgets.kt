package com.hm.ynabdemo.data.dto.budgets

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

data class Budgets(val recipesList: ArrayList<BudgetItem>) {
}