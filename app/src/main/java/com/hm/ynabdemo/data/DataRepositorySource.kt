package com.hm.ynabdemo.data


import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.dto.budgets.BudgetsResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by HalaAdly
 */

interface DataRepositorySource {

    suspend fun requestBudgets(): Flow<Resource<Budgets>>
//    suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
//    suspend fun addToFavourite(id: String): Flow<Resource<Boolean>>

}
