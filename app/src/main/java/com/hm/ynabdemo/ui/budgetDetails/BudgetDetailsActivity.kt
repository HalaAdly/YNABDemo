package com.hm.ynabdemo.ui.budgetDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.databinding.ActivityBudgetDetailsBinding
import com.hm.ynabdemo.databinding.FragmentHomeBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.utils.*
import com.task.ui.base.BaseActivity
import javax.inject.Inject

class BudgetDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: BudgetDetailsViewModel


    private lateinit var binding: ActivityBudgetDetailsBinding
    override fun initializeViewModel() {

    }

    override fun observeViewModel() {
        observe(viewModel.itemDetails, ::handleData)
        observeSnackBarMessages(viewModel.showSnackBar)
        observeToast(viewModel.showToast)
    }
    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>) {
        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }
    override fun initViewBinding() {
        binding = ActivityBudgetDetailsBinding.inflate(layoutInflater)

    }

    private fun handleData(status: Resource<BudgetDetailsItem>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { initializeView(it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { viewModel.showToastMessage(it) }
            }
        }
    }

    private fun showDataView(show: Boolean) {
//        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
//        binding.rvList.visibility = if (show) View.VISIBLE else View.GONE
//        binding.pbLoading.toGone()
    }
    private fun showLoadingView() {
//        binding.pbLoading.toVisible()
//        binding.tvNoData.toGone()
//        binding.rvList.toGone()
    }
    private fun initializeView(item: BudgetDetailsItem) {
        binding.item = item

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initIntentData(intent.getParcelableExtra(BUDGET_ITEM_KEY) ?: BudgetItem())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.getDetails()
    }
}