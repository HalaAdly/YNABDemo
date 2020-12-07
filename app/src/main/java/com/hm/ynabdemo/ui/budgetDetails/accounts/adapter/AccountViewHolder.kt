package com.hm.ynabdemo.ui.budgetDetails.accounts.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.databinding.AccountItemBinding

/**
 * Created by HalaAdly
 */

class AccountViewHolder(private val itemBinding: AccountItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: AccountItem, recyclerItemListener: RecyclerItemListener) {
        itemBinding.item = item
        itemBinding.rlAccountsItem.setOnClickListener {
            recyclerItemListener.onItemSelected(
                item
            )
        }
    }
}

