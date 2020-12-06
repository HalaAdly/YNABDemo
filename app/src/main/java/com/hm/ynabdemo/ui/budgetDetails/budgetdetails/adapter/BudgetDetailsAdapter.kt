package com.hm.ynabdemo.ui.budgetDetails.budgetdetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hm.ynabdemo.data.dto.budgetDetails.category.Category
import com.hm.ynabdemo.data.dto.budgetDetails.category.CategoryBase
import com.hm.ynabdemo.data.dto.budgetDetails.category.CategoryGroup
import com.hm.ynabdemo.databinding.BudgetDetailsHeaderBinding
import com.hm.ynabdemo.databinding.BudgetDetailsItemBinding
import com.hm.ynabdemo.ui.budgetDetails.accounts.adapter.AccountViewHolder
import com.hm.ynabdemo.ui.budgetDetails.accounts.adapter.RecyclerItemListener
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.BudgetDetailsFragmentViewModel


val Header = 1
val Normal = 2

class BudgetDetailsAdapter(
    private val data: ArrayList<CategoryBase>
) : RecyclerView.Adapter<BudgetDetailsAdapter.BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        when (viewType) {
            Normal -> {
                val itemBinding =
                    BudgetDetailsItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return DataViewHolder(itemBinding)
            }
            Header -> {
                val itemBinding =
                    BudgetDetailsHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return HeaderViewHolder(itemBinding)
            }

            else -> {
                val itemBinding =
                    BudgetDetailsItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return DataViewHolder(itemBinding)
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when {
            data[position] is CategoryGroup -> {
                Header
            }
            else -> {
                Normal
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class HeaderViewHolder(private val itemBinding: BudgetDetailsHeaderBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun <T> bind(item: T) {
            itemBinding.item = item as CategoryGroup
        }
    }

    class DataViewHolder(private val itemBinding: BudgetDetailsItemBinding) :
        BaseViewHolder(itemBinding.root) {

        override fun <T> bind(item: T) {
            itemBinding.item = item as Category
        }
    }

    abstract class BaseViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        abstract fun <T> bind(item: T);
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }
}