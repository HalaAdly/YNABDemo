package com.hm.ynabdemo.di


import com.hm.ynabdemo.ui.MainActivity
import com.hm.ynabdemo.ui.accountDetails.AccountDetailsActivity
import com.hm.ynabdemo.ui.addAccount.AddAccountActivity
import com.hm.ynabdemo.ui.budgetDetails.BudgetDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeBudgetDetailsActivity(): BudgetDetailsActivity

    @ContributesAndroidInjector()
    abstract fun contributeAddAccountActivity(): AddAccountActivity

    @ContributesAndroidInjector()
    abstract fun contributeAccountDetailsActivity(): AccountDetailsActivity

}
