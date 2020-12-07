package com.hm.ynabdemo.ui.accountDetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.ui.base.BaseViewModel
import javax.inject.Inject

class AccountDetailsViewModel @Inject constructor() : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val itemPrivate = MutableLiveData<AccountItem>()
    val itemAccount get() = itemPrivate

    fun initIntentData(item: AccountItem) {
        itemPrivate.value = item
    }

    fun getId(): String {
        val id = itemPrivate.value?.id
        return id ?: ""
    }

    fun getName(): String? {
        return itemPrivate.value?.name
    }
}