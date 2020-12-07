package com.hm.ynabdemo.data.remote

import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.Budgets


internal interface RemoteDataSource {
    suspend fun requestBudgets(): Resource<Budgets>
    suspend fun requestBudgetDetails(id: String): Resource<BudgetDetailsItem>
    suspend fun fetchUserAccountForBudget(id: String): Resource<Accounts>
}
