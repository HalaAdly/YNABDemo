package com.hm.ynabdemo

/**
 * Created by AhmedEltaher
 */
sealed class DataStatus {
    object Success : DataStatus()
    object Fail : DataStatus()
    object EmptyResponse : DataStatus()
}
