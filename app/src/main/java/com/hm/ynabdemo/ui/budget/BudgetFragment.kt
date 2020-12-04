package com.hm.ynabdemo.ui.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hm.ynabdemo.databinding.FragmentHomeBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.base.BaseFragment
import com.hm.ynabdemo.ui.budget.adapter.BudgetssAdapter
import javax.inject.Inject

class BudgetFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var budgetViewModel: BudgetViewModel
    override fun initializeViewModel() {
        budgetViewModel = viewModelFactory.create(BudgetViewModel::class.java)
    }

    override fun observeViewModel() {
        budgetViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
    }

    override fun initViewBinding() {
        binding = FragmentHomeBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var budgetAdapter: BudgetssAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = binding.root
        return view
    }
}