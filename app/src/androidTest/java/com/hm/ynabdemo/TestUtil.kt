package com.hm.ynabdemo

import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets


object TestUtil {
    var dataStatus: DataStatus = DataStatus.Success
    var budgets: Budgets = Budgets(arrayListOf())
    fun initData(): Budgets {
        budgets
        getData().let {
            budgets = Budgets(ArrayList(it))
        }
        return budgets
    }

    private fun getData(): ArrayList<BudgetItem> {
        val data = ArrayList<BudgetItem>()
        data.add(BudgetItem())
        data.add(BudgetItem())
        data.add(BudgetItem())
        return data
    }

}
