package com.hm.ynabdemo.usecase.errors

import com.hm.ynabdemo.data.error.Error
import com.hm.ynabdemo.data.error.mapper.ErrorMapper

import javax.inject.Inject

/**
 * Created by HalaAdly
 */

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorFactory {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
