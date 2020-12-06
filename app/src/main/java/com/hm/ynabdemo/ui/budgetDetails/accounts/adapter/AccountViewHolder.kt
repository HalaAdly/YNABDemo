package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.databinding.BudgetItemBinding

/**
 * Created by HalaAdly
 */

class AccountViewHolder(private val itemBinding: BudgetItemBinding) :
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

