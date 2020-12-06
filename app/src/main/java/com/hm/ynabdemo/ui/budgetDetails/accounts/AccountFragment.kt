package com.hm.ynabdemo.ui.budgetDetails.accounts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.databinding.FragmentHomeBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.base.BaseFragment
import com.hm.ynabdemo.ui.budgetDetails.BudgetDetailsActivity
import com.hm.ynabdemo.ui.budgetDetails.accounts.adapter.AccountsAdapter
import com.hm.ynabdemo.utils.*
import javax.inject.Inject

class AccountFragment : BaseFragment() {

    private lateinit var adapter: AccountsAdapter
    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var budgetViewModel: AccountViewModel

    override fun initializeViewModel() {
//        budgetViewModel = viewModelFactory.create(BudgetViewModel::class.java)
    }


    override fun observeViewModel() {
        observe(budgetViewModel.budgetsLiveData, ::handleList)
        observeEvent(budgetViewModel.openDetails, ::navigateToDetailsScreen)
        observeSnackBarMessages(budgetViewModel.showSnackBar, binding)
        observeToast(budgetViewModel.showToast, binding)
    }

    private fun navigateToDetailsScreen(navigateEvent: SingleEvent<BudgetItem>) {
        navigateEvent.getContentIfNotHandled()?.let {
            val nextScreenIntent =
                    Intent(requireContext(), BudgetDetailsActivity::class.java).apply {
                        putExtra(BUDGET_ITEM_KEY, it)
                    }
            startActivity(nextScreenIntent)
        }
    }


    private fun handleList(status: Resource<Budgets>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListData(budgets = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { budgetViewModel.showToastMessage(it) }
            }
        }
    }

    private fun bindListData(budgets: Budgets) {
        if (!(budgets.list.isNullOrEmpty())) {
            adapter = AccountsAdapter(budgetViewModel, budgets.list)
            binding.rvList.adapter = adapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
        binding.rvList.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.rvList.toGone()
    }

    override fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        budgetViewModel.getBudgets()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var budgetAdapter: AccountsAdapter
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = binding.root

        return view
    }
}