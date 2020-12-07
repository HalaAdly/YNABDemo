package com.hm.ynabdemo.data.dto.accounts

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Accounts(
    @SerializedName("list")
    @Expose val list: ArrayList<AccountItem>?
) : Parcelable