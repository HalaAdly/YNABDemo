package com.hm.ynabdemo.data.error.mapper

import com.hm.ynabdemo.App
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.error.*
import com.hm.ynabdemo.data.error.mapper.ErrorMapperInterface
import javax.inject.Inject

class ErrorMapper @Inject constructor() : ErrorMapperInterface {

    override fun getErrorString(errorId: Int): String {
        return App.context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error))
        ).withDefault { getErrorString(R.string.network_error) }
}
