package com.hm.ynabdemo.ui.budgetDetails.accounts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hm.ynabdemo.ACCOUNT_ITEM_KEY
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.accounts.AccountItem
import com.hm.ynabdemo.data.dto.accounts.Accounts
import com.hm.ynabdemo.databinding.FragmentAccountsBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.accountDetails.AccountDetailsActivity
import com.hm.ynabdemo.ui.addAccount.AddAccountActivity
import com.hm.ynabdemo.ui.base.BaseFragment
import com.hm.ynabdemo.ui.budgetDetails.accounts.adapter.AccountsAdapter
import com.hm.ynabdemo.utils.*
import javax.inject.Inject

class AccountFragment : BaseFragment() {

    private lateinit var adapter: AccountsAdapter
    private lateinit var binding: FragmentAccountsBinding

    @Inject
    lateinit var accountViewModel: AccountViewModel



    override fun observeViewModel() {
        observe(accountViewModel.accountsLiveData, ::handleList)
        observeEvent(accountViewModel.openDetails, ::navigateToDetailsScreen)
        observeEvent(accountViewModel.openAddAccount, ::navigateToAddAccountScreen)
        observeSnackBarMessages(accountViewModel.showSnackBar, binding)
        observeToast(accountViewModel.showToast, binding)
    }

    private fun navigateToDetailsScreen(navigateEvent: SingleEvent<AccountItem>) {
        navigateEvent.getContentIfNotHandled()?.let {
            val nextScreenIntent =
                Intent(requireContext(), AccountDetailsActivity::class.java).apply {
                    putExtra(ACCOUNT_ITEM_KEY, it)
                }
            startActivity(nextScreenIntent)
        }
    }


    private fun handleList(status: Resource<Accounts>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListData(it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { accountViewModel.showToastMessage(it) }
            }
        }
    }

    private fun bindListData(data: Accounts) {
        if (!(data.list.isNullOrEmpty())) {
            val dataList = accountViewModel.getSortedData(data.list)
            adapter = AccountsAdapter(accountViewModel, dataList)
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
        binding = FragmentAccountsBinding.inflate(layoutInflater)
    }

    private fun navigateToAddAccountScreen(navigateEvent: SingleEvent<String>) {
        navigateEvent.getContentIfNotHandled()?.let {
            val nextScreenIntent =
                Intent(requireContext(), AddAccountActivity::class.java).apply {
                    putExtra(BUDGET_ITEM_KEY, it)
                }
            startActivity(nextScreenIntent)
        }
    }

    val args: AccountFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        accountViewModel.initIntentData(args.StringBudgetId)
        arguments?.let {
            if (!it.getString(getString(R.string.budget_id), "").isNullOrEmpty())
                accountViewModel.initIntentData(
                    it.getString(
                        getString(R.string.budget_id), ""
                    )
                )
        }
        binding.btnAddAccount.setOnClickListener {
            accountViewModel.openAddAccount(accountViewModel.getBudgetID())
        }
        accountViewModel.getAccounts()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var accountsAdapter: AccountsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root

        return view
    }
}