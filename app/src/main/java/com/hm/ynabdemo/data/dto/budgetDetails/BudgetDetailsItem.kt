package com.hm.ynabdemo.data.dto.budgetDetails

import android.accounts.Account
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hm.ynabdemo.data.dto.budgetDetails.category.Category
import com.hm.ynabdemo.data.dto.budgetDetails.category.CategoryGroup
import com.hm.ynabdemo.data.dto.budgetDetails.category.Month
import com.hm.ynabdemo.data.dto.budgetDetails.payee.Payee
import com.hm.ynabdemo.data.dto.budgetDetails.payee.PayeeLocation
import com.hm.ynabdemo.data.dto.budgetDetails.transactions.ScheduledSubtransaction
import com.hm.ynabdemo.data.dto.budgetDetails.transactions.ScheduledTransaction
import com.hm.ynabdemo.data.dto.budgetDetails.transactions.Subtransaction
import com.hm.ynabdemo.data.dto.budgetDetails.transactions.Transaction
import com.hm.ynabdemo.data.dto.shared.CurrencyFormat
import com.hm.ynabdemo.data.dto.shared.DateFormat


class BudgetDetailsItem {
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

    @SerializedName("accounts")
    @Expose
    var accounts: List<Account>? = null

    @SerializedName("payees")
    @Expose
    var payees: List<Payee>? = null

    @SerializedName("payee_locations")
    @Expose
    var payeeLocations: List<PayeeLocation>? = null

    @SerializedName("category_groups")
    @Expose
    var categoryGroups: List<CategoryGroup>? = null

    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null

    @SerializedName("months")
    @Expose
    var months: List<Month>? = null

    @SerializedName("transactions")
    @Expose
    var transactions: List<Transaction>? = null

    @SerializedName("subtransactions")
    @Expose
    var subtransactions: List<Subtransaction>? = null

    @SerializedName("scheduled_transactions")
    @Expose
    var scheduledTransactions: List<ScheduledTransaction>? = null

    @SerializedName("scheduled_subtransactions")
    @Expose
    var scheduledSubtransactions: List<ScheduledSubtransaction>? = null
}
