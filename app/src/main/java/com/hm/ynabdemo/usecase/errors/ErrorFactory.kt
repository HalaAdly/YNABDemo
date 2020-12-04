package com.hm.ynabdemo.usecase.errors
import com.hm.ynabdemo.data.error.Error


interface ErrorFactory {
    fun getError(errorCode: Int): Error
}
