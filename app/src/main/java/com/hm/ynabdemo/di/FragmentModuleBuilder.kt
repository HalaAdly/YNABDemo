package com.hm.ynabdemo.di


import com.hm.ynabdemo.ui.budgetDetails.accounts.AccountFragment
import com.hm.ynabdemo.ui.budgetDetails.budgetdetails.BudgetDetailsFragment
import com.hm.ynabdemo.ui.home.budget.BudgetFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeBudgetFragment(): BudgetFragment

    @ContributesAndroidInjector()
    abstract fun contributeBudgetDetailsFragment(): BudgetDetailsFragment

    @ContributesAndroidInjector()
    abstract fun contributeAccountFragmentFragment(): AccountFragment

}
