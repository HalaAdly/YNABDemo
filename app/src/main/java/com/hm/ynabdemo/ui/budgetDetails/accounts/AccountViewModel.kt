package com.hm.ynabdemo.ui.budgetDetails.accounts

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.ui.base.BaseViewModel
import com.hm.ynabdemo.utils.SingleEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(
    private val repo: DataRepositorySource
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<String>()


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
    private val openAccountDetailsPrivate = MutableLiveData<SingleEvent<AccountItem>>()
    val openDetails: LiveData<SingleEvent<AccountItem>> get() = openAccountDetailsPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openAddAccountPrivate = MutableLiveData<SingleEvent<String>>()
    val openAddAccount: LiveData<SingleEvent<String>> get() = openAddAccountPrivate


    fun getAccounts() {
        viewModelScope.launch {
            accountsLiveDataPrivate.value = Resource.Loading()

            repo.requestAccounts(itemPrivate.value!!).collect {
                accountsLiveDataPrivate.value = it
            }

        }
    }

    fun openAddAccount(budgetID: String) {
        openAddAccountPrivate.value = SingleEvent(budgetID)
    }

    fun openAccountDetails(budgets: AccountItem) {
        openAccountDetailsPrivate.value = SingleEvent(budgets)
    }

    fun initIntentData(budgetID: String) {
        itemPrivate.value = budgetID
    }

    fun getSortedData(list: ArrayList<AccountItem>): List<AccountItem> {
        return list.filter { it.deleted == false }
            .sortedByDescending { it.balance }
    }

    fun getBudgetID(): String {
        val id = itemPrivate.value
        return id ?: ""
    }

}