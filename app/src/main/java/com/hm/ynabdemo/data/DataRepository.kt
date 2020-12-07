package com.hm.ynabdemo.data


import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * Created by HalaAdly
 */

class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val ioDispatcher: CoroutineContext
) :
    DataRepositorySource {

    override suspend fun requestBudgets(): Flow<Resource<Budgets>> {
        return flow {
            emit(remoteRepository.requestBudgets())
        }.flowOn(ioDispatcher)
    }

    override suspend fun requestBudgetDetails(id: String): Flow<Resource<BudgetDetailsItem>> {
        return flow {
            emit(remoteRepository.requestBudgetDetails(id))
        }.flowOn(ioDispatcher)
    }

    override suspend fun requestAccounts(budgetId: String): Flow<Resource<Accounts>> {
        return flow {
            emit(remoteRepository.fetchUserAccountForBudget(budgetId))
        }.flowOn(ioDispatcher)
    }

//    override suspend fun addToFavourite(id: String): Flow<Resource<Boolean>> {
//        return flow {
//            localRepository.getCachedFavourites().let {
//                it.data?.toMutableSet()?.let { set ->
//                    val isAdded = set.add(id)
//                    if (isAdded) {
//                        emit(localRepository.cacheFavourites(set))
//                    } else {
//                        emit(Resource.Success(false))
//                    }
//                }
//                it.errorCode?.let { errorCode ->
//                    emit(Resource.DataError<Boolean>(errorCode))
//                }
//            }
//        }.flowOn(ioDispatcher)
//    }

}
