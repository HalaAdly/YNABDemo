package com.hm.ynabdemo

import com.hm.ynabdemo.TestUtil.dataStatus
import com.hm.ynabdemo.TestUtil.initData
import com.hm.ynabdemo.data.DataRepositorySource
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.error.NETWORK_ERROR

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class TestDataRepository @Inject constructor() : DataRepositorySource {
    override suspend fun requestBudgets(): Flow<Resource<Budgets>> {
        return when (dataStatus) {
            DataStatus.Success -> {
                flow { emit(Resource.Success(initData())) }
            }
            DataStatus.Fail -> {
                flow { emit(Resource.DataError<Budgets>(errorCode = NETWORK_ERROR)) }
            }
            DataStatus.EmptyResponse -> {
                flow { emit(Resource.Success(Budgets(arrayListOf()))) }
            }
        }
    }

    override suspend fun requestBudgetDetails(budgetId: String): Flow<Resource<BudgetDetailsItem>> {
        return flow { emit(Resource.Success(BudgetDetailsItem())) }
    }

    override suspend fun requestAccounts(budgetId: String): Flow<Resource<Accounts>> {
        return flow { emit(Resource.Success(Accounts(arrayListOf()))) }
    }

}
