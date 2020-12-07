package com.hm.ynabdemo.utils

import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets


class TestModelsGenerator {
    private var budgets: Budgets = Budgets(arrayListOf())

    init {
        getData().let {
            budgets = Budgets(ArrayList(it))
        }
        print("this is $budgets")
    }

    fun generateBudgets(): Budgets {
        return budgets
    }

    fun generateBudgetsModelWithEmptyList(): Budgets {
        return Budgets(arrayListOf())
    }

    fun generateBudgetsItemModel(): BudgetItem {
        return budgets.list?.get(0)!!
    }


    /**
     * Helper function to get mock data
     *
     * @return data : Arraylist if simualted Budgets
     */

    private fun getData(): ArrayList<BudgetItem> {
        var data = ArrayList<BudgetItem>()
        data.add(BudgetItem())
        data.add(BudgetItem())
        data.add(BudgetItem())
        return data
    }
}
