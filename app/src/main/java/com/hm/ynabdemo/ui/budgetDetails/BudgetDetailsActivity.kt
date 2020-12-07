package com.hm.ynabdemo.ui.budgetDetails

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hm.ynabdemo.BUDGET_ITEM_KEY
import com.hm.ynabdemo.R
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import com.hm.ynabdemo.ui.budgetDetails.accounts.AccountFragmentArgs
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.BudgetDetailsFragmentArgs
import com.task.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_budget_details.*
import javax.inject.Inject


class BudgetDetailsActivity : BaseActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var viewModel: BudgetDetailsViewModel



    override fun observeViewModel() {

    }

    override fun initViewBinding() {
//        binding = ActivityBudgetDetailsBinding.inflate(layoutInflater)

    }

    lateinit var navController: NavController
    lateinit var navView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_details)
        viewModel.initIntentData(intent.getParcelableExtra(BUDGET_ITEM_KEY) ?: BudgetItem())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView = nav_view

        navController = findNavController(R.id.nav_host_fragment)
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
        //this is to pass data to first destination
        navController
            .setGraph(
                R.navigation.details_navigation,
                BudgetDetailsFragmentArgs(viewModel.getId()).toBundle()
            )
        supportActionBar?.title = viewModel.getName()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //this is to pass data when navigating bottom bar
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navigation_details -> {
                    val argument = NavArgument.Builder().setDefaultValue(viewModel.getId()).build()
                    destination.addArgument(getString(R.string.budget_id), argument)
                }
                R.id.navigation_accounts -> {
                    val argument = NavArgument.Builder().setDefaultValue(viewModel.getId()).build()
                    destination.addArgument(getString(R.string.budget_id), argument)
                }
            }
        }
        navView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentId = item.itemId
        var bundle: Bundle = Bundle()
        when (fragmentId) {
            R.id.navigation_details -> {
                bundle = BudgetDetailsFragmentArgs(viewModel.getId()).toBundle()
            }
            R.id.navigation_accounts -> {
                bundle = AccountFragmentArgs(viewModel.getId()).toBundle()
            }
        }

        navController.navigate(fragmentId, bundle)
        return true
    }

    //handle back to first fragment then finish to stop it from looping through fragments
    override fun onBackPressed() {
        if (navView.selectedItemId == R.id.navigation_details) {
            finish()
        } else {
            navView.selectedItemId = R.id.navigation_details
        }
    }
}