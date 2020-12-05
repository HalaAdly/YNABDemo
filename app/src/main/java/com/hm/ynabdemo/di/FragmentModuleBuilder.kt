package com.hm.ynabdemo.di


import com.hm.ynabdemo.ui.home.budget.BudgetFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeBudgetFragment(): BudgetFragment

}
