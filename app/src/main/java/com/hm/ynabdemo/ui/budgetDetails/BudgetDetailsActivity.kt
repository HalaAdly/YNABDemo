package com.hm.ynabdemo.ui.budgetDetails

import android.os.Bundle

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.BudgetDetailsFragmentArgs
import com.task.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_budget_details.*
import javax.inject.Inject

class BudgetDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: BudgetDetailsViewModel


    //    private lateinit var binding: ActivityBudgetDetailsBinding
    override fun initializeViewModel() {

    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
//        binding = ActivityBudgetDetailsBinding.inflate(layoutInflater)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_details)
        viewModel.initIntentData(intent.getParcelableExtra(BUDGET_ITEM_KEY) ?: BudgetItem())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navView: BottomNavigationView = nav_view

        val navController = findNavController(R.id.nav_host_fragment)
//
//
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_details, R.id.navigation_accounts
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navController
            .setGraph(
                R.navigation.details_navigation,
                BudgetDetailsFragmentArgs(viewModel.getId()).toBundle()
            )
        supportActionBar?.title = viewModel.getName()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}