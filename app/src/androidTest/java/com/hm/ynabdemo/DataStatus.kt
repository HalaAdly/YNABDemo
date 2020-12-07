package com.hm.ynabdemo

sealed class DataStatus {
    object Success : DataStatus()
    object Fail : DataStatus()
    object EmptyResponse : DataStatus()
}
