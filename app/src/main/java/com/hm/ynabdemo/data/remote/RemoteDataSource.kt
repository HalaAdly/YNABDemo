package com.hm.ynabdemo.data.remote

import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.dto.budgets.BudgetsResponse


internal interface RemoteDataSource {
    suspend fun requestBudgets(): Resource<Budgets>
}
