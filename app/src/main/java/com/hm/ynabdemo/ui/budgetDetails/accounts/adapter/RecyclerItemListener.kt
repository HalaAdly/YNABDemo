package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import com.hm.ynabdemo.data.dto.budgets.BudgetItem

interface RecyclerItemListener {
    fun onItemSelected(budgets : BudgetItem)
}