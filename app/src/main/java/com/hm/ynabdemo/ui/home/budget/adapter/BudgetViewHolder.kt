package com.hm.ynabdemo.ui.home.budget.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.databinding.BudgetItemBinding

/**
 * Created by HalaAdly
 */

class BudgetViewHolder(private val itemBinding: BudgetItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: BudgetItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.item = item
        itemBinding.rlBudgetsItem.setOnClickListener {
            recyclerItemListener.onItemSelected(
                item
            )
        }
    }
}

