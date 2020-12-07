package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import com.hm.ynabdemo.data.dto.accounts.AccountItem

interface RecyclerItemListener {
    fun onItemSelected(budgets: AccountItem)
}