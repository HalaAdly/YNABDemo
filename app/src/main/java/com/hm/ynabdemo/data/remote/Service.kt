package com.hm.ynabdemo.data.remote


import com.hm.ynabdemo.data.dto.accounts.AccountsResponse
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsResponse
import com.hm.ynabdemo.data.dto.budgets.BudgetsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("budgets")
    suspend fun fetchUserBudgets(): Response<BudgetsResponse>

    @GET("budgets/{budget_id}")
    suspend fun fetchBudgetDetails(@Path("budget_id") budgetId: String)
            : Response<BudgetDetailsResponse>

    @GET("budgets/{budget_id}/accounts")
    suspend fun fetchUserAccountForBudget(@Path("budget_id") budgetId: String)
            : Response<AccountsResponse>

}
