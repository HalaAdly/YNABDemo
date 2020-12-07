package com.hm.ynabdemo.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.dto.shared.CurrencyFormat
import java.text.SimpleDateFormat
import java.util.*


class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("bindServerDate")
        fun TextView.bindServerDate(oldDate: String?) {
            //2020-12-03T21:01:34+00:00
            var outputDateStr = oldDate
            try {
                val fromServer = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ")
                val myFormat = SimpleDateFormat("dd-MM-yyyy")
                val date: Date = fromServer.parse(oldDate)
                outputDateStr = myFormat.format(date)
            } catch (e: Exception) {

            }
            text = outputDateStr
        }

        @JvmStatic
        @BindingAdapter("bindCurrency")
        fun TextView.bindCurrency(currency: CurrencyFormat?) {
            //2020-12-03T21:01:34+00:00
            text = if (currency != null) {
                context.getString(R.string.currency_name, currency.currencySymbol)
            } else {
                context.getString(R.string.currency_name, "")

            }
        }


    }

}