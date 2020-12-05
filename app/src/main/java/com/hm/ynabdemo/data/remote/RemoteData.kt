package com.hm.ynabdemo.data.remote

import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.dto.budgets.BudgetsResponse
import com.hm.ynabdemo.data.error.*
import com.hm.ynabdemo.utils.NetworkConnectivity

import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 * Created by HalaAdly
 */

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator,
            private val networkConnectivity: NetworkConnectivity) : RemoteDataSource {

    override suspend fun requestBudgets(): Resource<Budgets> {
        val service = serviceGenerator.createService(Service::class.java)
        return when (val response = processCall(service::fetchUserBudgets)) {
            is BudgetsResponse -> {
                Resource.Success(data = Budgets(response.data?.budgets))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
