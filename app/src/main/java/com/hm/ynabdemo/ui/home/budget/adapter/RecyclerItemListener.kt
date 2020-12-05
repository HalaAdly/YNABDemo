package com.hm.ynabdemo.ui.home.budget.adapter

import com.hm.ynabdemo.data.dto.budgets.BudgetItem

interface RecyclerItemListener {
    fun onItemSelected(budgets : BudgetItem)
}