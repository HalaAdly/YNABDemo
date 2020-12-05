package com.hm.ynabdemo.ui.budgetDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.databinding.ActivityBudgetDetailsBinding
import com.hm.ynabdemo.databinding.FragmentHomeBinding
import com.hm.ynabdemo.ui.ViewModelFactory
import com.task.ui.base.BaseActivity
import javax.inject.Inject

class BudgetDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: BudgetDetailsViewModel


    private lateinit var binding: ActivityBudgetDetailsBinding
    override fun initializeViewModel() {

    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityBudgetDetailsBinding.inflate(layoutInflater)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initIntentData(intent.getParcelableExtra(BUDGET_ITEM_KEY) ?: BudgetItem())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}