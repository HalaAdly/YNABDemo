package com.hm.ynabdemo.ui.budgetDetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.base.BaseViewModel
import javax.inject.Inject

class BudgetDetailsViewModel @Inject constructor() : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<BudgetItem>()

    fun initIntentData(item: BudgetItem) {
        itemPrivate.value = item
    }

    fun getId(): String {
        val id = itemPrivate.value?.id
        return id ?: ""
    }

    fun getName(): String? {
        return itemPrivate.value?.name
    }
}