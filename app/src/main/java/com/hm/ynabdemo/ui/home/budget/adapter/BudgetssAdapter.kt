package com.hm.ynabdemo.ui.home.budget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.databinding.BudgetItemBinding
import com.hm.ynabdemo.ui.home.budget.BudgetViewModel

/**
 * Created by HalaAdly
 */

class BudgetssAdapter(
    private val budgetListViewModel: BudgetViewModel,
    private val budgetss: List<BudgetItem>
) : RecyclerView.Adapter<BudgetViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(item: BudgetItem) {
            budgetListViewModel.openBudgetDetails(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        val itemBinding =
            BudgetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BudgetViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(budgetss[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return budgetss.size
    }
}

