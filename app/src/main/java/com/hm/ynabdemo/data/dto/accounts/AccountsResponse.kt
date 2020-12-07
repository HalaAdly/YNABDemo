package com.hm.ynabdemo.data.dto.accounts

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class AccountsResponse(
    @SerializedName("data")
    @Expose var data: Data?
) : Parcelable {
    @Parcelize
    class Data : Parcelable {
        @SerializedName("accounts")
        @Expose
        var accounts: ArrayList<AccountItem>? = null

        @SerializedName("server_knowledge")
        @Expose
        var serverKnowledge: Int? = null
    }
}

