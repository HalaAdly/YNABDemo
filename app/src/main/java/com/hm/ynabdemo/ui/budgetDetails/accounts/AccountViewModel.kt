package com.hm.ynabdemo.ui.budgetDetails.accounts

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.base.BaseViewModel
import com.hm.ynabdemo.utils.SingleEvent
import com.hm.ynabdemo.utils.wrapEspressoIdlingResource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<String>()
    fun openBudgetDetails(item: BudgetItem) {
        openBudgetsDetailsPrivate.value = SingleEvent(item)
    }

    /**
     * Data --> LiveData, Exposed as LiveData, Locally in viewModel as MutableLiveData
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val accountsLiveDataPrivate = MutableLiveData<Resource<Accounts>>()
    val accountsLiveData: LiveData<Resource<Accounts>> get() = accountsLiveDataPrivate


    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openBudgetsDetailsPrivate = MutableLiveData<SingleEvent<BudgetItem>>()
    val openDetails: LiveData<SingleEvent<BudgetItem>> get() = openBudgetsDetailsPrivate


    fun getAccounts() {
        viewModelScope.launch {
            accountsLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                repo.requestAccounts(itemPrivate.value!!).collect {
                    accountsLiveDataPrivate.value = it
                }
            }
        }
    }

    fun openBudgetsDetails(budgets: BudgetItem) {
        openBudgetsDetailsPrivate.value = SingleEvent(budgets)
    }

    fun initIntentData(budgetID: String) {
        itemPrivate.value = budgetID
    }

}