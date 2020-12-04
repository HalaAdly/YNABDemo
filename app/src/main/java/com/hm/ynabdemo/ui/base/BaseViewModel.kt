package com.hm.ynabdemo.ui.base

import androidx.lifecycle.ViewModel
import com.hm.ynabdemo.data.error.mapper.ErrorMapper
import com.hm.ynabdemo.usecase.errors.ErrorManager


/**
 * Created by HalaAdly
 */


abstract class BaseViewModel : ViewModel() {
    /**Inject Singleton ErrorManager
     * Use this errorManager to get the Errors
     */
    val errorManager: ErrorManager = ErrorManager(ErrorMapper())
}
