package com.hm.ynabdemo.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.dto.shared.CurrencyFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min
import kotlin.math.pow


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

        /**
         * Converts a milliunits amount to a currency amount
         * @param milliunits - The milliunits amount (i.e. 293294)
         * @param [currencyDecimalDigits] - The number of decimals in the currency (i.e. 2 for USD)
         */
        @JvmStatic
        @BindingAdapter("mapBalance")
        fun TextView.mapBalance(milliunits: String) {
            text = if (milliunits.isNotEmpty() && milliunits.matches("-?\\d+(\\.\\d+)?".toRegex()))
                context.getString(
                    R.string.balance,
                    convertMilliUnitsToCurrencyAmount(milliunits.toDouble(), 2.toDouble())
                )
            else
                context.getString(R.string.balance, "")
        }

        //the api returns balance in milliunits this is to format it to ###,###.##

        @JvmStatic
        fun convertMilliUnitsToCurrencyAmount(
            milliunits: Double, currencyDecimalDigits: Double
        ): String {
            var numberToRoundTo =
                10.toDouble().pow(3 - min(3.toDouble(), currencyDecimalDigits))
            numberToRoundTo = 1 / numberToRoundTo
            val rounded = Math.round(milliunits * numberToRoundTo) / numberToRoundTo
            val currencyAmount = rounded * (0.1 / 10.toDouble().pow(2.toDouble()))
            val decimalFormat = DecimalFormat("###,###.##")
            return decimalFormat.format(currencyAmount)
        }

    }

}