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

class BudgetDetailsViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<BudgetItem>()

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemDetailsPrivate = MutableLiveData<Resource<BudgetDetailsItem>>()
    val itemDetails: LiveData<Resource<BudgetDetailsItem>> get() = itemDetailsPrivate

    /**
     * Error handling as UI
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar: LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate

    fun initIntentData(item: BudgetItem) {
        itemPrivate.value = item
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

    fun getDetails() {
        viewModelScope.launch {
            itemDetailsPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                repo.requestBudgetDetails(itemPrivate.value?.id!!).collect {
                    itemDetailsPrivate.value = it
                }
            }
        }
    }
}