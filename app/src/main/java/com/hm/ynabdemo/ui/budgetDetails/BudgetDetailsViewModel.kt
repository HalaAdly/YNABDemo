package com.hm.ynabdemo.ui.budgetDetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.base.BaseViewModel
import com.hm.ynabdemo.utils.SingleEvent
import com.hm.ynabdemo.utils.wrapEspressoIdlingResource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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