package com.hm.ynabdemo.data


import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import kotlinx.coroutines.flow.Flow

/**
 * Created by HalaAdly
 */

interface DataRepositorySource {

    suspend fun requestBudgets(): Flow<Resource<Budgets>>
    suspend fun requestBudgetDetails(budgetId: String): Flow<Resource<BudgetDetailsItem>>
    suspend fun requestAccounts(budgetId: String): Flow<Resource<Accounts>>


}
