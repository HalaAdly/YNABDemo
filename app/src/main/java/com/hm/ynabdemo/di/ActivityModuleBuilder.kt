package com.hm.ynabdemo.di


import com.hm.ynabdemo.MainActivity
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

}
