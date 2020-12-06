package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.databinding.BudgetItemBinding
import com.hm.ynabdemo.ui.budgetDetails.accounts.AccountViewModel


/**
 * Created by HalaAdly
 */

class AccountsAdapter(
        private val budgetListViewModel: AccountViewModel,
        private val budgetss: List<BudgetItem>
) : RecyclerView.Adapter<AccountViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(item: BudgetItem) {
            budgetListViewModel.openBudgetDetails(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val itemBinding =
            BudgetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(budgetss[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return budgetss.size
    }
}

