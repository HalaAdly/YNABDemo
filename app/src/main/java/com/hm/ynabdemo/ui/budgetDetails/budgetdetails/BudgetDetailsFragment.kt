package com.hm.ynabdemo.ui.budgetDetails.budgetdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgetDetails.BudgetDetailsItem
import com.hm.ynabdemo.data.dto.budgetDetails.category.CategoryBase
import com.hm.ynabdemo.databinding.FragmentBudgetSummaryBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.base.BaseFragment
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.adapter.BudgetDetailsAdapter
import com.hm.ynabdemo.utils.observe
import com.hm.ynabdemo.utils.toGone
import com.hm.ynabdemo.utils.toVisible
import javax.inject.Inject

class BudgetDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentBudgetSummaryBinding

    @Inject
    lateinit var budgetViewModel: BudgetDetailsFragmentViewModel

    override fun initializeViewModel() {
//        budgetViewModel = viewModelFactory.create(BudgetViewModel::class.java)
    }


    override fun observeViewModel() {
        observe(budgetViewModel.itemDetails, ::handleDetails)
        observeSnackBarMessages(budgetViewModel.showSnackBar, binding)
        observeToast(budgetViewModel.showToast, binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    private fun handleDetails(status: Resource<BudgetDetailsItem>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindData(budget = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { budgetViewModel.showToastMessage(it) }
            }
        }
    }

    private fun bindData(budget: BudgetDetailsItem) {
        if (budget.id != null) {
            if (!(budget.categoryGroups.isNullOrEmpty())) {
                val data = ArrayList<CategoryBase>()
                for (cat in budget.categoryGroups!!) {
                    data.add(cat)
                    budget.categories?.filter {
                        it.categoryGroupId.equals(cat.id!!)
                    }?.let { data.addAll(it) }
                }
                val adapter = BudgetDetailsAdapter(data)
                binding.rvList.adapter = adapter
            }
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

    val args: BudgetDetailsFragmentArgs by navArgs()
    override fun initViewBinding() {
        binding = FragmentBudgetSummaryBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        budgetViewModel.initIntentData(args.StringBudgetId)
        arguments?.let {
            if (!it.getString(getString(R.string.budget_id), "").isNullOrEmpty())
                budgetViewModel.initIntentData(
                    it.getString(
                        getString(R.string.budget_id), ""
                    )
                )
        }
        budgetViewModel.getDetails()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)

        return view
    }
}