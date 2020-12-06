package com.hm.ynabdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.home.budget.BudgetViewModel
import com.hm.ynabdemo.ui.budgetDetails.BudgetDetailsViewModel
import com.hm.ynabdemo.ui.budgetDetails.accounts.AccountViewModel
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.BudgetDetailsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Since dagger
 * support multibinding you are free to bind as may ViewModels as you want.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BudgetViewModel::class)
    abstract fun bindBudgetViewModel(viewModel: BudgetViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BudgetDetailsViewModel::class)
    abstract fun bindBudgetDetailsViewModel(viewModel: BudgetDetailsViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(viewModel: AccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BudgetDetailsFragmentViewModel::class)
    abstract fun bindBudgetDetailsFragmentViewModel(viewModel: BudgetDetailsFragmentViewModel): ViewModel


}
