package com.hm.ynabdemo.data.dto.accounts

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountItem() : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("on_budget")
    @Expose
    var onBudget: Boolean? = null

    @SerializedName("closed")
    @Expose
    var closed: Boolean? = null

    @SerializedName("note")
    @Expose
    var note: String? = null

    @SerializedName("balance")
    @Expose
    var balance: String? = null

    @SerializedName("cleared_balance")
    @Expose
    var clearedBalance: String? = null

    @SerializedName("uncleared_balance")
    @Expose
    var unclearedBalance: String? = null

    @SerializedName("transfer_payee_id")
    @Expose
    var transferPayeeId: String? = null

    @SerializedName("deleted")
    @Expose
    var deleted: Boolean? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        type = parcel.readString()
        onBudget = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        closed = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        note = parcel.readString()
        balance = parcel.readString()
        clearedBalance = parcel.readString()
        unclearedBalance = parcel.readString()
        transferPayeeId = parcel.readString()
        deleted = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeValue(onBudget)
        parcel.writeValue(closed)
        parcel.writeString(note)
        parcel.writeString(balance)
        parcel.writeString(clearedBalance)
        parcel.writeString(unclearedBalance)
        parcel.writeString(transferPayeeId)
        parcel.writeValue(deleted)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AccountItem> {
        override fun createFromParcel(parcel: Parcel): AccountItem {
            return AccountItem(parcel)
        }

        override fun newArray(size: Int): Array<AccountItem?> {
            return arrayOfNulls(size)
        }
    }


}