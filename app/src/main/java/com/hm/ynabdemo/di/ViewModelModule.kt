package com.hm.ynabdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hm.ynabdemo.ui.ViewModelFactory
import com.hm.ynabdemo.ui.budget.BudgetViewModel
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


}
