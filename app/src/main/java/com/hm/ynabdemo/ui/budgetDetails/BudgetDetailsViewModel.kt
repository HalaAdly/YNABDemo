package com.hm.ynabdemo.ui.budgetDetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.base.BaseViewModel
import javax.inject.Inject

class BudgetDetailsViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<BudgetItem>()
    fun initIntentData(item: BudgetItem) {
        itemPrivate.value = item
    }
}