package com.hm.ynabdemo.ui.budgetDetails.budgetdetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.ui.base.BaseViewModel
import com.hm.ynabdemo.utils.SingleEvent
import com.hm.ynabdemo.utils.wrapEspressoIdlingResource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class BudgetDetailsFragmentViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<String>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemDetailsPrivate = MutableLiveData<Resource<BudgetDetailsItem>>()
    val itemDetails: LiveData<Resource<BudgetDetailsItem>> get() = itemDetailsPrivate

    fun initIntentData(budgetID: String) {
        itemPrivate.value = budgetID
    }

    fun getDetails() {
        viewModelScope.launch {
            itemDetailsPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                repo.requestBudgetDetails(itemPrivate.value!!).collect {
                    itemDetailsPrivate.value = it
                }
            }
        }
    }


}