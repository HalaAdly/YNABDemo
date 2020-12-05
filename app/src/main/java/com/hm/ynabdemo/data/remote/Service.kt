package com.hm.ynabdemo.data.remote


import com.hm.ynabdemo.data.dto.budgets.BudgetsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("budgets")
    suspend fun fetchUserBudgets(): Response<BudgetsResponse>

    @GET("budgets/{budget_id}")
    suspend fun fetchBudgetDetails(@Path("budget_id") budgetId: String)
            : Response<BudgetsResponse>


}
