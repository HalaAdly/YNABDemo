package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.databinding.AccountItemBinding
import com.hm.ynabdemo.ui.budgetDetails.accounts.AccountViewModel


/**
 * Created by HalaAdly
 */

class AccountsAdapter(
    private val accountListViewModel: AccountViewModel,
    private val list: List<AccountItem>
) : RecyclerView.Adapter<AccountViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(item: AccountItem) {
            accountListViewModel.openAccountDetails(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val itemBinding =
            AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(list[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

