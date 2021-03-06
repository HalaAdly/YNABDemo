package com.hm.ynabdemo.ui.home.budget

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.ui.base.BaseViewModel
import com.hm.ynabdemo.utils.SingleEvent

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class BudgetViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    fun openBudgetDetails(item: BudgetItem) {
        openBudgetsDetailsPrivate.value = SingleEvent(item)
    }

    /**
     * Data --> LiveData, Exposed as LiveData, Locally in viewModel as MutableLiveData
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val budgetsLiveDataPrivate = MutableLiveData<Resource<Budgets>>()
    val budgetsLiveData: LiveData<Resource<Budgets>> get() = budgetsLiveDataPrivate


    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openBudgetsDetailsPrivate = MutableLiveData<SingleEvent<BudgetItem>>()
    val openDetails: LiveData<SingleEvent<BudgetItem>> get() = openBudgetsDetailsPrivate




    fun getBudgets() {
        viewModelScope.launch {
            budgetsLiveDataPrivate.value = Resource.Loading()
                repo.requestBudgets().collect {
                    budgetsLiveDataPrivate.value = it
                }

        }
    }

    fun openBudgetsDetails(budgets: BudgetItem) {
        openBudgetsDetailsPrivate.value = SingleEvent(budgets)
    }




}