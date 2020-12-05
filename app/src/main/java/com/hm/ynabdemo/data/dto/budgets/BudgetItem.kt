package com.hm.ynabdemo.data.dto.budgets

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hm.ynabdemo.data.dto.shared.CurrencyFormat
import com.hm.ynabdemo.data.dto.shared.DateFormat
import kotlinx.android.parcel.Parcelize

class BudgetItem() : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("last_modified_on")
    @Expose
    var lastModifiedOn: String? = null

    @SerializedName("first_month")
    @Expose
    var firstMonth: String? = null

    @SerializedName("last_month")
    @Expose
    var lastMonth: String? = null

    @SerializedName("date_format")
    @Expose
    var dateFormat: DateFormat? = null

    @SerializedName("currency_format")
    @Expose
    var currencyFormat: CurrencyFormat? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        lastModifiedOn = parcel.readString()
        firstMonth = parcel.readString()
        lastMonth = parcel.readString()
        dateFormat = parcel.readParcelable(DateFormat::class.java.classLoader)
        currencyFormat = parcel.readParcelable(CurrencyFormat::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(lastModifiedOn)
        parcel.writeString(firstMonth)
        parcel.writeString(lastMonth)
        parcel.writeParcelable(dateFormat, flags)
        parcel.writeParcelable(currencyFormat, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BudgetItem> {
        override fun createFromParcel(parcel: Parcel): BudgetItem {
            return BudgetItem(parcel)
        }

        override fun newArray(size: Int): Array<BudgetItem?> {
            return arrayOfNulls(size)
        }
    }


}